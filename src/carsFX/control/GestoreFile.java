package carsFX.control;

import carsFX.Principale;
import carsFX.model.Auto;

import java.io.*;
import java.util.ArrayList;

public final class GestoreFile {

    private static final String ext = ".dat";

    public static void inserimento(final Auto t) throws Exception {

        final FileOutputStream fOUT;
        final ObjectOutputStream oOUT;

        final File file = new File(Principale.choosen.name().toLowerCase() + ext);

        if (!file.exists()) {
            fOUT = new FileOutputStream(file);
        } else {
            fOUT = new FileOutputStream(file, true);
        }
        oOUT = new ObjectOutputStream(fOUT);
        oOUT.writeObject(t);

        oOUT.flush();
        oOUT.close();
        fOUT.close();

    }

    public static ArrayList<Auto> read() throws Exception {
        final ArrayList<Auto> auto = new ArrayList<>();
        final File file = new File(Principale.choosen.name().toLowerCase() + ext);
        if (file.exists()) {
            final FileInputStream fIN = new FileInputStream(file);
            final ObjectInputStream oIN = new ObjectInputStream(fIN);

            while (true) {
                try {
                    auto.add((Auto) oIN.readObject());
                } catch (Exception exc) {
                    break;
                }
            }

            oIN.close();
            fIN.close();
        }

        return auto;
    }

    public static boolean delete(final Auto auto) throws Exception {
        final File diApp = new File("appoggio" + ext);
        final File orig = new File(Principale.choosen.name().toLowerCase() + ext);

        final FileOutputStream fOUT = new FileOutputStream(diApp);
        final ObjectOutputStream oOUT = new ObjectOutputStream(fOUT);
        boolean b = false;

        final FileInputStream fIN = new FileInputStream(orig);
        final ObjectInputStream oIN = new ObjectInputStream(fIN);

        while (true) {
            try {
                final Auto letta = (Auto) oIN.readObject();
                if (letta.equals(auto))
                    b = true;
                else
                    oOUT.writeObject(letta);
            } catch (Exception exc) {
                break;
            }
        }

        oOUT.close();
        fOUT.close();
        oIN.close();
        fIN.close();

        orig.delete();
        diApp.renameTo(orig);

        return b;
    }

}
