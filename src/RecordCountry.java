import java.util.Scanner;

class Countries {
    String name;
    double square;
}
public class RecordCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите кол-во стран => ");
        int n = sc.nextInt();
        TheCountry[]country=new TheCountry[n];
        System.out.println("Введите информацию о странах: ");
        for (int i = 0; i < country.length; i++) {
            sc.nextLine();
            country[i]=new TheCountry();
            System.out.print("Название "+(i+1)+"-й страны => ");
            country[i].name=sc.nextLine();
            System.out.print("Площадь "+(i+1)+"-й страны => ");
            country[i].square=sc.nextDouble();
        }

        System.out.println("\n Характеристики стран:");
        for (TheCountry theCountry : country) {
            System.out.println("\t" + theCountry.name + "\t" + theCountry.square + " млн кв. км");
        }

        int nommax=0;
        double max=country[nommax].square;
        for(int i = 0; i < country.length; i++)
            if (country[i].square>max) {
                max = country[i].square;
                nommax=i;
            }
        System.out.println("\n Страна с максимальной площадью :");
        System.out.println("\t"+country[nommax].name+"\t"+country[nommax].square + " млн кв. км");

        for(int i = 0; i < country.length-1; i++)
            for (int j = 0; j < country.length-1-i; j++)
                if (country[j].square>country[j+1].square){
                    TheCountry rab=country[j];
                    country[j]=country[j+1];
                    country[j+1]=rab;
                }
        System.out.println("\n Отсортированный список по площади: ");//
        for (TheCountry theCountry : country) {
            System.out.println("\t" + theCountry.name + "\t" + theCountry.square + " млн кв. км");
        }

        for (int i = 0; i < country.length-1; i++)
            for (int j = 0; j < country.length-i-1; j++)
                if(country [j].name.compareTo(country[i+1].name)>0){
                    TheCountry rab=country[j];
                    country[j]=country[j+1];
                    country[j+1]=rab;
                }
        System.out.println("\n Отсортированный список по названиям:");
        for (TheCountry theCountry : country) {
            System.out.println("\t" + theCountry.name + "\t" + theCountry.square + " млн кв. км");
        }

        double s=0;
        for (TheCountry theCountry : country) s += theCountry.square;
        double sr = s/country.length;
        System.out.println("Средняя площадь ="+sr);
        System.out.println("\n Страны, с площадью больше средней");
        for (TheCountry theCountry : country) {
            if (theCountry.square > sr)
                System.out.println("\t" + theCountry.name + "\t" + theCountry.square + " млн кв. км");
        }

        sc.nextLine();
        System.out.println("Введите название искомой страны=> ");
        String name=sc.nextLine();
        int nom=-1;
        for (int i = 0; i < country.length; i++)
            if (name.equalsIgnoreCase(country[i].name))
                nom=i;
        if (nom!= -1) {
            System.out.println("Такая страна есть в списке. Это " +country[nom].name+" "+country[nom].square+" млн кв. км");
        }
        else System.out.println("Такой страны нет в списке");

    }
}
