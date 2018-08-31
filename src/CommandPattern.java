public class CommandPattern {
    public static void main(String args[]){
        Document document = new Document();
        DocumentCommand[] dcs = {new AddCharCommand(document,'h'),
                new AddCharCommand(document,'i')};
        System.out.println(document.text);
        for(DocumentCommand dc : dcs){
            dc.execute();
        }
        System.out.println(document.text);
        DocumentCommand[] dcs1 = {new DeleteCharCommand(document),
                new DeleteCharCommand(document)};
        for(DocumentCommand dc : dcs1){
            dc.execute();
        }
        System.out.println(document.text);
    }
}
class Document{
    String text = "Hello ";
}
abstract class DocumentCommand{
    Document document;
    DocumentCommand(Document d){
        this.document = d;
    }
    public abstract void execute();
}
class AddCharCommand extends DocumentCommand{
    char c;
    AddCharCommand(Document d,char c){
        super(d);
        this.c = c;
    }
    @Override
    public void execute() {
        document.text = document.text +c;

    }
}
class DeleteCharCommand extends DocumentCommand{

    DeleteCharCommand(Document d) {
        super(d);
    }

    @Override
    public void execute() {
        document.text = document.text.substring(0,document.text.length()-1);
    }
}
