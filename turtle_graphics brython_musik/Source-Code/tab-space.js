function handleTabKey(event) 
{
    if (event.key === "Tab") {  // Wird zu spät von Python abgefangen/ "nicht registriert(?)", womit der Wechsel zum nächsten Element nicht verhindert werden kann
        // Verhindert das Standardverhalten der Tab-Taste (das Bewegen zum nächsten Element)
        event.preventDefault();
        if(window.insertElement){
            window.insertElement("\t"); // Ruft die Python-Funktion auf
        }
    }
    
    window.loadLinenumbers();
}