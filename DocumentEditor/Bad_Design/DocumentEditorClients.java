import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class DocumentEditor {
    // isi class me ham sabkuch define kr denge 
    private List<String> documentElements ; 
    private String renderedDocument ; 

    public DocumentEditor(){
        documentElements= new ArrayList<>() ; 
        renderedDocument="" ; 
    }


    // Adds text as a plain string 

    public void  addText(String text){
        documentElements.add(text) ; 
    }
    // adds an image represented by its file path 

    public void addImage(String imagePath){
        documentElements.add(imagePath) ; 
    }

    // renders the document by checkign the type of each elelment at run time 


    public String  renderDocument(){
        if(renderedDocument.isEmpty()){
        
            StringBuilder result= new StringBuilder() ; 
            for( String element : documentElements){

                if(element.length()>4 && (element.endsWith(".jpg") || element.endsWith(".png"))){
                    result.append("[Image: ").append(element).append("]\n") ; 

                }else{
                    result.append(element).append("\n") ; 
                 }
            }

            renderedDocument= result.toString() ; 
          

        }
        String temp= renderedDocument ; 
        renderedDocument="";
        return temp ; 

    }


    public void saveToFile(){

        try {
            FileWriter writer= new FileWriter("document.txt") ;
            writer.write(renderDocument()); 
            writer.close() ; 
            System.out.println("Document saved to document.txt");
            
        } catch (IOException e) {
            System.out.println("Error : Unable to open the fiel for writing ");


        }

    }
}
 
public class DocumentEditorClients {

    public static void main(String[] args){

        DocumentEditor editor = new DocumentEditor() ; 
        editor.addImage("abcddd.png");
        editor.addImage("rizzzzz.jpg");
        editor.addText("This is a docuemnt editor . ");
        System.out.println(editor.renderDocument());
      

        editor.addText("This is a docuemnt editor .a ");
        editor.addText("This is a docuemnt editor .  b ");
        editor.addText("This is a docuemnt editor . c ");
        System.out.println(editor.renderDocument()); 


    }
}