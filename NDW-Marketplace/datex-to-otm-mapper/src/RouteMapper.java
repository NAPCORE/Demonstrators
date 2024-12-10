import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class RouteMapper {

    public static final String SITUATION_ID_PROPERTY = "X-SituationId";
    public static final String SITUATION_VERSION_PROPERTY = "X-SituationVersion";
    public static final String SITUATION_RECORD_ID_PROPERTY = "X-SituationRecordId";
    public static final String SITUATION_RECORD_VERSION_PROPERTY = "X-SituationRecordVersion";
    public static final String MARK_AS_REMOVED_PROPERTY = "X-MarkAsRemoved";

    private GeoMapper geoMapper;

    public Route toRoute(SituationRecord situationRecord, Situation situation) {
        return new Route(
            situationRecord.getId(),
            situationRecord.getSituationRecordCreationTime(),
            situationRecord.getSituationRecordVersionTime(),
            toExternalAttributes(situationRecord, situation),
            toGeoReferences(situationRecord.getGroupOfLocations()),
            toRouteConstraint(situationRecord)
        );
    }

    private Map<String, Object> toExternalAttributes(
            SituationRecord situationRecord,
            Situation situation) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
        map.put(SITUATION_ID_PROPERTY, situation.getId());
        map.put(SITUATION_VERSION_PROPERTY, situation.getVersion());
        map.put(SITUATION_RECORD_ID_PROPERTY, situationRecord.getId());
        map.put(SITUATION_RECORD_VERSION_PROPERTY, situationRecord.getVersion());
        return map;
    }

    private RouteConstraint toRouteConstraint(SituationRecord situationRecord) {
        String type = "andConstraint";
        List<Object> constraints = new ArrayList<>();
        constraints.add(toTimeWindow(situationRecord.getValidity().getValidityTimeSpecification()));

        if (situationRecord.getType().equals("RoadOrCarriagewayOrLaneManagement")) {
            constraints.add(toGenericConstraint("closed"));
        }

        Optional<ValueBoundConstraint> valueBoundConstraintWidth = toValueBoundConstraintWidth(situationRecord);
        if (valueBoundConstraintWidth.isPresent()) {
            constraints.add(toValueBoundConstraintWidth(situationRecord));
        }
        AndConstraint andConstraint = new AndConstraint(constraints, type);
        return new RouteConstraint(andConstraint);
    }

    private Optional<ValueBoundConstraint> toValueBoundConstraintWidth(SituationRecord situationRecord) {
        if (situationRecord.getImpact() != null && situationRecord.getImpact().getResidualRoadWidth() != 0) {
            String unit = "meter";
            int value = situationRecord.getImpact().getResidualRoadWidth();
            String description = String.format("Max. width %d %s", value, unit);

            return Optional.of(new ValueBoundConstraint(
                    description,
                    "width",
                    new MaximumConstraint(value, unit),
                    "valueBoundConstraint"
            ));
        }
        return Optional.empty();
    }

    private Object toTimeWindow(ValidityTimeSpecification validityTimeSpecification) {
        List<ValidPeriod> periods = validityTimeSpecification.getValidPeriods();
        if (periods == null || periods.isEmpty()) {
            return toTimeWindowConstraint(validityTimeSpecification.getOverallStartTime(),
                validityTimeSpecification.getOverallEndTime());
        }
        List<TimeWindowConstraint> timeWindowConstraints = toTimeWindowConstraints(periods);
        return timeWindowConstraints.size() == 1 ? timeWindowConstraints.get(0) :
                new OrConstraint(timeWindowConstraints, "orConstraint");
    }

    private List<TimeWindowConstraint> toTimeWindowConstraints(List<ValidPeriod> periods) {
        return periods.stream()
                .map(this::toTimeWindowConstraint)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private TimeWindowConstraint toTimeWindowConstraint(ValidPeriod period) {
        return toTimeWindowConstraint(period.getStartOfPeriod(), period.getEndOfPeriod());
    }

    private TimeWindowConstraint toTimeWindowConstraint(String startTime, String endTime) {
        if (endTime == null) {
            String description = String.format("Starts at %s", startTime);
            return new TimeWindowConstraint(startTime, null, description, "timeWindowConstraint");
        }
        String description = String.format("Starts at %s and ends at %s", startTime, endTime);
        return new TimeWindowConstraint(
                startTime,
                endTime,
                description,
                "timeWindowConstraint"
            );
    }

    private Optional<GenericConstraint> toGenericConstraint(String description) {
        String type = "genericConstraint";
        return Optional.of(
                new GenericConstraint(description, type));
    }

    private Optional<GeoMapper> toGeoReferences(GroupOfLocations groupOfLocations) {
        String type = "tmcArrayGeoReference";
        AlertCLinear alertCLinear = groupOfLocations.getAlertCLinear();
        if (alertCLinear != null) {
            Points primaryPoint = new Points(
                alertCLinear.getAlertCMethod4PrimaryPointLocation().getAlertCLocation().getSpecificLocation(),
                alertCLinear.getAlertCDirection().getAlertCDirectionCoded()
            );

            Points secondaryPoint = new Points(
                alertCLinear.getAlertCMethod4SecondaryPointLocation().getAlertCLocation().getSpecificLocation(),
                alertCLinear.getAlertCDirection().getAlertCDirectionCoded()
            );

            List<Points> points = new ArrayList<>();
            points.add(primaryPoint);
            points.add(secondaryPoint);

            geoMapper = new GeoMapper(
                type,
                alertCLinear.getAlertCLocationCountryCode(),
                alertCLinear.getAlertCLocationTableNumber(),
                alertCLinear.getAlertCLocationTableVersion(),
                points
            );
            return Optional.of(geoMapper);
        }
        return Optional.empty();
    }
}
