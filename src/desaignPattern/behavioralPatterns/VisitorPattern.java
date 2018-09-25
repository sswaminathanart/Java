package desaignPattern.behavioralPatterns;

public class VisitorPattern {
    public static void main(String args[])
    {
        File[] files = {new WrodFile(),new PictureFile()};
        FileVisitor fv = new PrintFileVisitor();
        for (File f : files){
            f.visit(fv);
        }
    }

}

abstract class File{
  abstract void visit(FileVisitor fv);
}

class WrodFile extends File {

    @Override
    void visit(FileVisitor fv) {
        fv.visitWord(this);

    }
}

class PictureFile extends File {

    @Override
    void visit(FileVisitor fv) {
        fv.visitPicuture(this);

    }
}

abstract class FileVisitor{
    abstract void visitWord(WrodFile f);
    abstract void visitPicuture(PictureFile p);


}

class PrintFileVisitor extends FileVisitor {

    @Override
    void visitWord(WrodFile f) {
        System.out.println("Open Wrod and Print File");
    }

    @Override
    void visitPicuture(PictureFile p) {
        System.out.println("Open Picuture view and Print Picture File");

    }
}