import java.util.Scanner;

class Sotrudnik{
    String fam, im, otch, doljnost;
    int oklad, countChildrens;
    Children[]childrens = null;
}
class Children{
    String name;
    int age;
}

public class MainClass {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Введите количество сотрудников => ");
        int count=sc.nextInt();
        sc.nextLine();
        Sotrudnik []sotr=new Sotrudnik[count];
        for (int i = 0; i < sotr.length; i++) {

            System.out.println("Введите информацию о "+(i+1)+" сотруднике: ");

            sotr[i]=new Sotrudnik();
            System.out.print("Введите фамилию сотрудника => ");
            sotr[i].fam= sc.nextLine();

            System.out.print("Введите его имя => ");
            sotr[i].im=sc.nextLine();

            System.out.print("Введите его отчество => ");
            sotr[i].otch=sc.nextLine();

            System.out.print("Введите его должность => ");
            sotr[i].doljnost=sc.nextLine();

            System.out.print("Введите его оклад => ");
            sotr[i].oklad=sc.nextInt();
            sc.nextLine();

            System.out.print("Введите кол-во детей => ");
            sotr[i].countChildrens=sc.nextInt();
            sc.nextLine();
            if(sotr[i].countChildrens!=0) {
                sotr[i].childrens = new Children[sotr[i].countChildrens];
                for (int j = 0; j < sotr[i].countChildrens; j++) {
                    sotr[i].childrens[j] = new Children();
                    System.out.println("Введите имя "+(i+1)+" малыша => ");
                    sotr[i].childrens[j].name = sc.nextLine();
                    System.out.println("Введите возраст "+(i+1)+" малыша => ");
                    sotr[i].childrens[j].age = sc.nextInt();
                    sc.nextLine();

                }
            }
        }

        System.out.println( "\n Сотрудники фирмы: \n фам \t имя \t отч \t должность \t оклад \t количество детей");
        for (Sotrudnik s:sotr) {
            System.out.print(s.fam + "\t" + s.im + "\t" + s.otch + "\t "+ s.doljnost + "\t" + s.oklad + "\t" + s.countChildrens+ "\n");
            if(s.countChildrens!=0){
                System.out.println("Дети: ");
                for (int i=0; i<s.countChildrens; i++){
                    System.out.println(s.childrens[i].name + "\t\t" + s.childrens[i].age);
                }
            }

        }

    }

}
