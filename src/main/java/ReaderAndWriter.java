import java.io.*;

public class ReaderAndWriter {
    public static void main(String[] args) throws Exception {
        final String PATH = "test.txt";
        File file = new File(PATH);
        if (file.exists()) {
            System.out.println("File exists!");
        }else{
            System.out.println("File does not exist, please create it first!");
        }


        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("vimfile.bin"));
        out.writeInt(10);
        out.writeDouble(3.333);
        out.writeChar('a');
        out.writeBoolean(true);
        out.writeUTF("Test");
        out.close();

        System.out.println("\nFile written!");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("vimfile.bin"));
        System.out.println(in.readInt());
        System.out.println(in.readDouble());
        System.out.println(in.readChar());
        System.out.println(in.readBoolean());
        System.out.println(in.readUTF());
        in.close();

        System.out.println("\ndata.dat file read!");
        ObjectInputStream in_data = new ObjectInputStream(new FileInputStream("data.dat"));
        while (in_data.available() > 0) {
            System.out.println(in_data.readUTF());
        }
        in_data.close();

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("person.bin"));
        Person person_washington = new Person("George Washington",new Date(2,22,1732),new Date(12,14,1779));
        Person person_chavez = new Person("Cesar Chavez",new Date(3,31,1927),new Date(4,23,1993));
        Person person = new Person("Yezhi Wu",new Date(12,30,1993),null);

        outputStream.writeObject(person_washington);
        outputStream.writeObject(person_chavez);
        outputStream.writeObject(person);

        outputStream.close();

        System.out.println("\nOjbect file read!");
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("person.bin"));

        Person new_person1 = (Person) inputStream.readObject();
        Person new_person2 = (Person) inputStream.readObject();
        Person new_person3 = (Person) inputStream.readObject();

        System.out.println(new_person1.getName());
        System.out.println(new_person2.getName());
        System.out.println(new_person3.getName());

        inputStream.close();


        RandomAccessFile raf = new RandomAccessFile("raf", "rw");
        System.out.println("\nRandom Access File");
        System.out.println(raf.getFilePointer());
        raf.writeInt(1);
        System.out.println(raf.getFilePointer());
        raf.writeInt(2);
        System.out.println(raf.getFilePointer());
        raf.writeInt(3);
        System.out.println(raf.getFilePointer());
        raf.writeInt(4);
        System.out.println(raf.getFilePointer());
        raf.writeInt(5);
        System.out.println(raf.getFilePointer());
        raf.writeInt(6);
        System.out.println(raf.getFilePointer());

        /**
         * Writes the String "Dead men tell no tales." at position 10.
         * Writes the String "A pirate's life for me!" at position 50.
         * Writes the String "Yo ho!" at position 90.
         */
        raf.seek(10);
        raf.writeUTF("Dead men tell no tales.");
        raf.seek(50);
        raf.writeUTF("A pirate's life for me!");
        raf.seek(90);
        raf.writeUTF("o ho!");

        System.out.println("\nCursor: " + raf.getFilePointer());

        raf.seek(10);
        System.out.println(raf.readUTF());
        raf.close();

    }
}
