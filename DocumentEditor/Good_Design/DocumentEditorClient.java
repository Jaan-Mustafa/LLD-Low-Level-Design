
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

interface DocumentElement {
    public abstract String render();
}

class TextElement implements DocumentElement {
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}

class ImageElement implements DocumentElement {
    private String imagePath;

    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String render() {
        StringBuilder st = new StringBuilder();

        st.append("[Image : ]").append(imagePath).append(" \n");
        return st.toString();

    }

}

class NewLineElement implements DocumentElement {
    @Override
    public String render() {
        return "\n";
    }
}

class TabSpaceElement implements DocumentElement {
    @Override
    public String render() {
        return "\t";
    }
}

class Document {

    private List<DocumentElement> documentElements = new ArrayList<>();
    // we can define extra mehtod inside any class that implements DocumentElement , but we can't call it . as type is DocumentElement only . 

    public void addElement(DocumentElement element) {

        // so basically element is object of class DocumentElement
        documentElements.add(element);
    }

    // Renders the document by concatenating the render output of all elements
    public String render() {
        StringBuilder result = new StringBuilder();

        for (DocumentElement element : documentElements) {
            result.append(element.render());
        }
        return result.toString();
    }

}

// Persistance Interface

interface Persistance {
    void save(String data);
}

class FileStorage implements Persistance {
    @Override
    public void save(String data) {
        try {
            FileWriter outFile = new FileWriter("document.txt");
            outFile.write(data);
            outFile.close();
            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }

    }

}

class DBStorage implements Persistance {
    @Override
    public void save(String data) {
        // save to DB
    }
}

class DocumentEditor {

    private Document document;
    private Persistance storage;
    private String renderedDocument = "";

    public DocumentEditor(Document d, Persistance st) {
        this.document = d;
        this.storage = st;

    }

    public void addText(String text) {
        document.addElement(new TextElement(text));

    }

    public void addImage(String imagePath) {
        document.addElement(new ImageElement(imagePath));

    }

    // adds new line in the doc
    public void addNewLine() {
        document.addElement(new NewLineElement());

    }

    // adds a tab space to the document
    public void addTabSpace() {
        document.addElement(new TabSpaceElement());

    }

    public String renderDocument() {
        if (renderedDocument.isEmpty()) {
            renderedDocument = document.render();
        }
        return renderedDocument;

    }

    public void saveDocument() {
        storage.save(renderDocument());

    }
}

public class DocumentEditorClient {

    public static void main(String[] args) {

        Document document = new Document();
        Persistance persistance = new FileStorage();
        DocumentEditor editor = new DocumentEditor(document, persistance);

        // Simulate a client using hte editor with common text formatting features

        editor.addText("This is rizabul ");
        editor.addNewLine();
        editor.addText("this is rizabul b ");
        editor.addImage("picture.jpg");

        System.out.println(editor.renderDocument());
        editor.saveDocument();

    }

}
