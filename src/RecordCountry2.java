import java.util.Objects;
import java.util.Scanner;

class TheCountry {
    String name;
    double square;
}

public class RecordCountry2{

    public static TheCountry[] setCountryArr(int k){
        Scanner sc=new Scanner(System.in);
        TheCountry[] country =new TheCountry[k];

        System.out.println("Введите информацию о странах: ");
        for (int i = 0; i < country.length; i++) {
            country[i]=new TheCountry();
            System.out.print("Название "+(i+1)+"-й страны => ");
            country[i].name=sc.nextLine();
            System.out.print("Площадь "+(i+1)+"-й страны => ");
            country[i].square=sc.nextDouble();
            sc.nextLine();
        }
        return country;
    }

    public static void showArray(TheCountry[] cntr){
        for (TheCountry theCountry : cntr) {
            System.out.println("\t" + theCountry.name + "\t" + theCountry.square + " млн кв. км");
        }
    }

    public static void showCountry(TheCountry cntr){
        System.out.println("\t"+cntr.name+"\t"+cntr.square+" млн кв. км");
    }

    public static int NomMax(TheCountry[]st){
        int nommax = 0;
        double max = st[nommax].square;
        for (int i = 0; i < st.length; i++)
            if (st[i].square > max) {
                max= st[i].square;
                nommax=i;
            }
        return nommax;
    }

    public static void sortSquare(TheCountry[]cntr){
        for (int i = 0; i < cntr.length-1; i++)
            for (int j = 0; j < cntr.length-1-i; j++)
                if (cntr[j].square>cntr[j+1].square){
                    TheCountry rab=cntr[j];
                    cntr[j]=cntr[j+1];
                    cntr[j+1]=rab;
                }
    }

    public static void sortName(TheCountry[] cntr) {
        for (int i = 0; i < cntr.length-1; i++)
            for (int j = 0; j < cntr.length-i-1; j++)
                if(cntr[j].name.compareTo(cntr[i+1].name)>0) {
                    TheCountry rab=cntr[j];
                    cntr[j]=cntr[j+1];
                    cntr[j+1]=rab;
                }
    }

    public static double avgSquare( TheCountry[] cntr){
        double s=0;
        for (TheCountry theCountry : cntr) s += theCountry.square;
        return s/cntr.length;
    }

    public static TheCountry[] Bigger(TheCountry[] cntr){
        double sr=avgSquare(cntr);
        int count=0;
        for (TheCountry value : cntr) {
            if (value.square > sr)
                ++count;
        }
        if (count != 0){
            TheCountry[] bigCountry=new TheCountry[count];
            int n=-1;
            for (TheCountry theCountry : cntr)
                if (theCountry.square > sr) {
                    bigCountry[++n] = theCountry;
                }
            return bigCountry;
        }
        else return null;
    }

    public static TheCountry findForName(TheCountry[] cntr, String name){
        int n=-1;
        for (int i = 0; i < cntr.length; i++)
            if (name.equals(cntr[i].name))
                n=i;
        if (n!= -1) {
            return cntr[n];
        }
        else return null;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Введите количество стран => ");
        int n=sc.nextInt();
        TheCountry[] country = setCountryArr(n);

        System.out.println("\n Характеристики стран:");
        showArray(country);

        int nommax=NomMax(country);
        System.out.println("\n Страна с максимальной площадью:");
        showCountry(country[nommax]);

        sortSquare(country);
        System.out.println("\n Отсортированный список по площади:");
        showArray(country);

        sortName(country);
        System.out.println("\n Отсортированный список по названиям:");
        showArray(country);

        System.out.println("Средняя площадь ="+avgSquare(country));

        System.out.println("\n Страны, с площадью больше средней");
        TheCountry[] larger=Bigger(country);
        showArray(Objects.requireNonNull(larger));

        System.out.println("\n ПОИСК СТРАНЫ \n Введите название страны => ");
        sc.nextLine();
        String sname=sc.nextLine();
        TheCountry sfind =findForName(country, sname);
        if (sfind!=null) {
            showCountry(sfind);
        }
        else {
            System.out.println("Такой страны нет в списке!");
        }
    }
}