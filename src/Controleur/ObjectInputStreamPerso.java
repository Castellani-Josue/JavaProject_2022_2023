package Controleur;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectInputStreamPerso extends ObjectOutputStream
{

    public ObjectInputStreamPerso(OutputStream out) throws IOException {
        super(out);
    }

    protected ObjectInputStreamPerso() throws IOException, SecurityException
    {
        super();
    }

    public void writeStreamHeader() throws IOException
    {
        return;
    }

}
