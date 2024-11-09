package ru.bahanov.pracJava.task2;

import ru.bahanov.pracJava.task2.C.C;

public class Main {
    public static void main(String[] args) {
        Main zad = new Main();
        //zad.A();
        //zad.B();
        zad.C();
    }

    /*public void A(){
        A task2 = new A();
        List<Integer> arr = task2.loadArr();
        List<String> minMax = task2.largeOrSmallLen(arr);
        System.out.println(minMax.get(0));
        System.out.println(minMax.get(1));

        task2.sortLen(arr);

        task2.avgLen(arr);

        task2.findDublicate(arr);

        task2.findEvenNumb(arr);

        task2.sortNumb(arr);

        task2.someNum(arr);

        task2.findSecondPalindrome(arr);

        task2.findRoots();
    }*/

    /*public void B(){
        B task2 = new B();

        task2.tableMult();

        List<Integer> arr = new ArrayList<>(task2.loadArr());


        System.out.println("Исходный массив: "+arr);
        System.out.println("Массив в обратном порядке: " + arr.reversed());

        //task2.intervalCheck();

        task2.splitOnThree();

        task2.sixQues(100,81);

        task2.convertSystem();

        task2.convertAnySys();

        task2.monthName();
    }*/



    public void C() {
        C task2 = new C();



        // Задача 1. Упорядочить строки/столбцы по k-му столбцу/строке
        System.out.println("1. Упорядочить строки/столбцы по k-му столбцу/строке");
        task2.generateMatr();
        task2.printMatr();
        task2.sortMatrK();
        task2.printMatr();

        task2.generateMatr();
        task2.printMatr();


        System.out.println("3. Макс. количество возрастающих/убывающих элементов подряд");
        task2.upMatr();
        task2.downMatr();

        System.out.println("4. Сумма элементов между первыми положительными элементами строки");
        task2.sumBetweenPos();

        System.out.println("5. Числа от 1 до k в матрице N x N");
        task2.printMatr(task2.fromOneToK());

        System.out.println("6. Округление элементов матрицы");
        task2.roundNumb();

        System.out.println("7. Поворот матрицы на 90/180/270°");
        task2.matrRotate();

        System.out.println("8. Вычисление определителя матрицы");
        task2.opredMatr();

        System.out.println("9. Матрица с вычитанием среднего по строкам");
        task2.avgRow();

        System.out.println("10. Удаление строк/столбцов с максимальным элементом");
        task2.dltMaxEl();

        System.out.println("12. Перемещение минимального элемента в заданную позицию");
        task2.moveMinEl();

        System.out.println("13. Перемещение нулей в конец строк");
        task2.moveZeroToEnd();

        System.out.println("14. Подсчет седловых точек");
        task2.countSaddlePos();

        System.out.println("15. Перестановка строк по возрастанию суммы элементов");
        task2.sortRowByMin();

        System.out.println("16. Поиск числа локальных минимумов");
        task2.findLocalMin();

    }

}