import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.input.BOMInputStream;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;  


public class App {
    public static void main(String[] args) throws Exception {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true); // Enable namespace awareness

            DocumentBuilder db = dbf.newDocumentBuilder();
            URL url = new URL("https://data-service.d37c3234d8454420babf.westeurope.aksapp.io/api/752571257922158592_data");
            BOMInputStream bomInputStream = BOMInputStream.builder().setInputStream(url.openStream()).get();
            Document doc = db.parse(new InputSource(new InputStreamReader(bomInputStream)));

            JAXBContext jaxbContext = JAXBContext.newInstance(D2LogicalModel.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            D2LogicalModel d2LogicalModel = (D2LogicalModel) jaxbUnmarshaller.unmarshal(doc);
    
            List<Route> routes = new ArrayList<>();
            RouteMapper routeMapper = new RouteMapper();
    
            if (d2LogicalModel.getPayloadPublication().getSituations() == null || d2LogicalModel.getPayloadPublication().getSituations().isEmpty()) {
                System.out.println("No situations found.");
            } else {
                
                for (Situation situation : d2LogicalModel.getPayloadPublication().getSituations()) {
                    System.out.println("Situation found.");
                    // Check if situation records are present
                    if (situation.getSituationRecords() == null || situation.getSituationRecords().isEmpty()) {
                        System.out.println("No situation records found.");
                    } else {
                        // Iterate through situation records
                        for (SituationRecord situationRecord : situation.getSituationRecords()) {
                            routes.add(routeMapper.toRoute(situationRecord, situation));
                            System.out.println("Type of situation record: " + situationRecord.getType());
                        }
                    }
                }
            }
            Gson gson = new Gson();
            try {  
                String json = gson.toJson(routes);

                URL dataServiceUrl = new URL("https://data-service.d37c3234d8454420babf.westeurope.aksapp.io/api/752571257922158592_otm"); 
                HttpURLConnection connection = (HttpURLConnection)dataServiceUrl.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Accept", "application/json");
                connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    
                try (OutputStream outputStream = connection.getOutputStream()) {
                    byte[] input = json.getBytes(StandardCharsets.UTF_8);
                    outputStream.write(input, 0, input.length);
                }

                if (connection.getResponseCode() == 200) {
                    System.out.println("Successfully written data to dataservice");
                } else {
                    System.out.println("Failed to write data to dataservice");
                    throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
                }
            }  
            catch (Exception e) {  
                e.printStackTrace();  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
}
