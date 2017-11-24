## EXAMPLE JSON REQUESTS ##
1. POST Greeting:
    
    URL: http://localhost:9090/api/greetings
    ```json
    {
       "data":{
            "type":"greetings",
            "attributes":
            {
             "content": "test3" 
            }
        }
    }    
    ```

1. GET http://localhost:9090/api/greetings
1. POST Message

   URL: http://localhost:9090/api/greetings/1/message
    ```json
        {
            "data":
            {
                "type":"messages",
                "attributes":
                {
                    "title":"billy",
                    "messageContent":"FRED_Message2" 
                }
            }
            
        }
    ```
