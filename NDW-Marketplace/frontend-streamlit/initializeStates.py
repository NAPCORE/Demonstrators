import streamlit as st

def initStates():
    if 'show_json' not in st.session_state:
        st.session_state['show_json'] = False

    if 'show_catalog' not in st.session_state:
        st.session_state['show_catalog'] = False

    if 'show_info' not in st.session_state:
        st.session_state['show_info'] = False

    if 'first_request' not in st.session_state:
        st.session_state['first_request'] = True
    
    if 'first_load' not in st.session_state:
        st.session_state['first_load'] = True

    if 'current_policy' not in st.session_state:
        st.session_state['current_policy'] = ""

def show_catalog_callback():
    st.session_state['show_catalog'] = True

def show_info_callback():
    st.session_state['show_info'] = True
