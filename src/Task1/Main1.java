package Task1;

import Task1.MyLinkedListValue;
import Task1.Polenom;

import java.util.Scanner;

import static java.lang.Math.*;

public class Main1 {
    public static void main(String[] args) {
        MyLinkedListValue list1 = new MyLinkedListValue();
        MyLinkedListValue list2 = new MyLinkedListValue();

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество элементов для первого многочлена");
        int polenom1 = sc.nextInt();

        for (int i = polenom1 - 1; i >= 0; i--) {
            System.out.println("Введите коэфициент a" + i + " элемента");
            Scanner scan = new Scanner(System.in);
            int a = scan.nextInt();
            list1.add(new Polenom(a, i));
        }

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Введите количество элементов для второго многочлена");
        int polenom2 = sc.nextInt();

        for (int i = polenom2 - 1; i >= 0; i--) {
            System.out.println("Введите коэфициент a" + i + " элемента");
            Scanner scan = new Scanner(System.in);
            int a = scan.nextInt();
            list2.add(new Polenom(a, i));
        }
        System.out.print("Многочлен p : ");
        output(list1);
        System.out.println();
        System.out.print("Многочлен q : ");
        output(list2);
        System.out.println();
        if (equality(list1, list2)) {
            System.out.println("Введенные многочлены равны");
        } else {
            System.out.println("1) Введенные многочлены не равны");
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целочисленное значение точки x для 1-го многочлена");
        int x = scanner.nextInt();
        System.out.println("Введите целочисленное значение точки x для 2-го многочлена");
        int x1 = scanner.nextInt();
        System.out.print("2)");
        System.out.print("Значение 1-го многочлена в целочисленной точке " + x + " равно : ");
        System.out.println(meaning(list1, x));
        System.out.print("Значение 2-го многочлена в целочисленной точке " + x1 + " равно : ");
        System.out.println(meaning(list2, x1));
        add(list1,list2);
        System.out.println(round(sin(5) + 3 ));

    }

    public static boolean equality(MyLinkedListValue p, MyLinkedListValue q) {
        if (p.size() != q.size()) {
            return false;
        }
        for (int i = p.size()-1; i >= 0; i--) {
            if (p.get(i).getKof()!=q.get(i).getKof()) {
                return false;
            }
        }
        return  true;
    }

    public static int meaning(MyLinkedListValue p, int x) {
        int result = 0;
        for (int i = 0; i < p.size(); i++) {
            result += p.get(i).getKof() * Math.pow(x, p.get(i).getStep());
        }
        return result;
    }

    public static void add(MyLinkedListValue p, MyLinkedListValue q) {
        MyLinkedListValue sum = new MyLinkedListValue();

        if (p.size() == q.size()) {
        for (int k = 0; k < p.size(); k++) {
                sum.add(new Polenom(p.get(k).getKof() + q.get(k).getKof(), p.get(k).getStep()));
            }
        }

        if (p.size() > q.size()) {
            int n = p.size() - q.size();
            for (int i =0 ; i<n; i++){
                sum.add(new Polenom(p.get(i).getKof(),p.get(i).getStep()));
            }
            for (int i = 0; i<q.size()&&n<p.size();i++,n++) {
                sum.add(new Polenom(p.get(n).getKof() +q.get(i).getKof(),q.get(i).getStep()));
            }
        }

        if (q.size()>p.size()){
            int n = q.size() - p.size();
            for (int i =0 ; i<n;i++){
                sum.add(new Polenom(q.get(i).getKof(),q.get(i).getStep()));
            }
            for (int i = 0; i <p.size()&&n<q.size() ; i++,n++) {
                sum.add(new Polenom(q.get(n).getKof() + p.get(i).getKof(),p.get(i).getStep()));
            }
        }
        System.out.print("3)Сумма веденных вами многочленов равна : ");
        output(sum);
    }

    public static void output (MyLinkedListValue list){
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i).getKof();
            int n = list.get(i).getStep();
            if (a > 0) {
                if (i==0){
                    System.out.print(a);
                }else
                System.out.print("+" + a);
            }
            if (a < 0) {
                System.out.print(a);
            }
            if (n == 0) {
                continue;
            }
            if (n == 1) {
                System.out.print("x");
            } else {
                System.out.print("x^" + n);
            }
        }
        System.out.println();
    }
}