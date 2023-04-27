package TypeOeuvre;
public class ClassificationOeuvre
{
    static public final int ALL;
    static public final int pegi6;
    static public final int pegi9;
    static public final int pegi12;
    static public final int pegi14;
    static public final int pegi16;
    static public final int pegi18;
    static
    {
        ALL = 0;
        pegi6 = 6;
        pegi9 = 9;
        pegi12 = 12;
        pegi14 = 14;
        pegi16 = 16;
        pegi18 = 18;
    }

    /*public static boolean estValeurValide(int valeur) {
        switch (valeur) {
            case 0:
            case 6:
            case 9:
            case 12:
            case 14:
            case pegi16:
            case pegi18:
                return true;
            default:
                return false;
        }
    }*/
}
