// 1. Target interface expected by the client : 

interface IReports{
    String getJsonData(String data ) ; 


}


class XmlDataProvider {
    String getXmlData(String data) {
        int sep = data.indexOf(':');
        String name = data.substring(0, sep);
        String id = data.substring(sep + 1);
        // Build an XML representation
        return "<user>"
                + "<name>" + name + "</name>"
                + "<id>" + id + "</id>"
                + "</user>";
    }
}

class XmlDataProviderAdapter implements IReports{
    // Is a relationship with IReports 
    // Has a relationship with XmlDataProvider 
    private XmlDataProvider xmlDataProvider  ; 
    public XmlDataProviderAdapter(XmlDataProvider provider){
        this.xmlDataProvider= provider ; 
    }





    public String getJsonData(String data){

        // get xml from the adaptee 
        String xml= xmlDataProvider.getXmlData(data) ; 
        // naively parse out values 
        int startName = xml.indexOf("<name>") + 6;
        int endName = xml.indexOf("</name>");
        String name = xml.substring(startName, endName);

        int startId = xml.indexOf("<id>") + 4;
        int endId = xml.indexOf("</id>");
        String id = xml.substring(startId, endId);

        return "{\"name\":\"" + name + "\", \"id\":" + id + "}";


    }
}

class Client {
    public void getReport(IReports report , String rawData){
         System.out.println("Processed JSON: "
                + report.getJsonData(rawData));
    }
}

public class AdapterPattern {


     public static void main(String[] args) {
         XmlDataProvider xmlProv= new XmlDataProvider() ; 

         // make adapter 
         IReports adapter = new XmlDataProviderAdapter(xmlProv);
         String rawData="Alice:42" ; 
         Client client= new Client();
         client.getReport(adapter , rawData); 
     }

    
}
