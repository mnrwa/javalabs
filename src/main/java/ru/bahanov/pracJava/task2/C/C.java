package ru.bahanov.pracJava.task2.C;

import java.security.Principal;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class C {
    private Integer[][] matr;
    private int sizeMatr;
    private int k;


    public int getSizeMatr() {
        return sizeMatr;
    }

    public void setSizeMatr(int sizeMatr) {
        this.sizeMatr = sizeMatr;
    }

    public void setMatr(int i, int j, int value) {
        matr[i][j] = value;
    }
    public void setMatr(Integer[][] matr) {
        this.matr = matr;
    }

    public Integer[][] getMatr() {
        return matr;
    }



    public void generateMatr() {
        System.out.println("Введите размер матрицы: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        setSizeMatr(n);
        matr = new Integer[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                setMatr(i, j, random.nextInt(-n, n));
            }
        }
        System.out.println();
    }

    public void generateMatr(int size,int start) {
        Random random = new Random();
        matr = new Integer[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                setMatr(i,j ,random.nextInt(start) - 2);
            }
        }
    }

    public void generateMatr(int size) {
        setSizeMatr(size);
        matr = new Integer[size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                setMatr(i, j, random.nextInt(-3, 50));
            }
        }
        System.out.println("Новая матрица с размерами " + size + " x " + size + ": ");
    }

    public void printMatr() {
        int sizeMatr = getSizeMatr();
        for (int i = 0; i < sizeMatr; i++) {
            for (int j = 0; j < sizeMatr; j++) {
                System.out.printf("%3d ", getMatr()[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public <T> void printMatr(T[][] matr) {
        int sizeMatr = matr.length;
        for (int i = 0; i < sizeMatr; i++) {
            for (int j = 0; j < sizeMatr; j++) {
                if (matr[i][j] instanceof Integer) {
                    System.out.format("%3d ", matr[i][j]);
                } else if (matr[i][j] instanceof Double) {
                    System.out.format("%.2f ", matr[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }



    public void sortMatrK() {
        System.out.println("Введите k (Не более " + (getSizeMatr() - 1) + "): ");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int matrSize = getSizeMatr();

        int temp;
        for (int i = 0; i < matrSize - 1; i++) {
            for (int j = 0; j < matrSize - i - 1; j++) {
                if (matr[j][k] > matr[j + 1][k]) {
                    temp = matr[j][k];
                    matr[j][k] = matr[j + 1][k];
                    matr[j + 1][k] = temp;
                }
            }
        }
    }

    public void upMatr() {
        int lenUp = 0;
        String str = "";

        for (int i = 0; i < getSizeMatr(); i++) {
            int tempLen = 1;
            String tempStr = String.valueOf(getMatr()[i][0]);

            for (int j = 1; j < getSizeMatr(); j++) {
                if (getMatr()[i][j] > getMatr()[i][j - 1]) {
                    tempLen++;
                    tempStr += " " + getMatr()[i][j];
                } else {
                    if (tempLen > lenUp) {
                        lenUp = tempLen;
                        str = tempStr;
                    }
                    tempLen = 1;
                    tempStr = String.valueOf(getMatr()[i][j]);
                }
            }

            if (tempLen > lenUp) {
                lenUp = tempLen;
                str = tempStr;
            }
        }

        System.out.println("Наибольшая возрастающая последовательность длины " + lenUp + ": " + str);
    }

    public void downMatr() {
        int lenDown = 0;
        String str = "";

        for (int i = 0; i < getSizeMatr(); i++) {
            int tempLen = 1;
            String tempStr = String.valueOf(getMatr()[i][0]);

            for (int j = 1; j < getSizeMatr(); j++) {
                if (getMatr()[i][j] < getMatr()[i][j - 1]) {
                    tempLen++;
                    tempStr += " " + getMatr()[i][j];
                } else {
                    if (tempLen > lenDown) {
                        lenDown = tempLen;
                        str = tempStr;
                    }
                    tempLen = 1;
                    tempStr = String.valueOf(getMatr()[i][j]);
                }
            }

            if (tempLen > lenDown) {
                lenDown = tempLen;
                str = tempStr;
            }
        }

        System.out.println("Наибольшая убывающая последовательность длины " + lenDown + ": " + str);
    }

    public void sumBetweenPos() {
        int totalSum = 0;

        for (int i = 0; i < getSizeMatr(); i++) {
            int firstPosIndex = -1;
            int secondPosIndex = -1;

            for (int j = 0; j < getSizeMatr(); j++) {
                if (getMatr()[i][j] > 0) {
                    firstPosIndex = j;
                    break;
                }
            }

            if (firstPosIndex == -1) continue;

            for (int j = firstPosIndex + 1; j < getSizeMatr(); j++) {
                if (getMatr()[i][j] > 0) {
                    secondPosIndex = j;
                    break;
                }
            }

            if (secondPosIndex == -1)
                continue;

            for (int j = firstPosIndex + 1; j < secondPosIndex; j++) {
                totalSum += getMatr()[i][j];
            }
        }
        System.out.println("Сумма элементов между двумя положительными числами: " + totalSum);
    }

    public Integer[][] fromOneToK(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число k: ");
        int k = sc.nextInt();

        int n = (int) Math.ceil(Math.sqrt(k));
        Integer[][] matrix = new Integer[n][n];

        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count <= k) {
                    matrix[i][j] = count;
                    count++;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public void roundNumb(){
        Random random = new Random();
        Double[][] matr = new Double[5][5];
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr.length; j++) {
                matr[i][j] = random.nextInt(1, 15) / (double) random.nextInt(1, 10);
            }
        }

        printMatr(matr);

        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr.length; j++) {
                matr[i][j] = Math.ceil(matr[i][j]);
            }
        }

        System.out.println("Новая дробная матрица: ");
        printMatr(matr);
    }

    public void matrRotate() {
        Integer[][] matr = getMatr();

        System.out.println("Исходнаая матрциа: ");
        printMatr(matr);

        Integer[][] rotated90 = new Integer[getSizeMatr()][getSizeMatr()];
        for (int i = 0; i < getSizeMatr(); i++) {
            for (int j = 0; j < getSizeMatr(); j++) {
                rotated90[j][getSizeMatr() - i - 1] = matr[i][j];
            }
        }
        System.out.println("Матрица после поворота на 90 градусов:");
        printMatr(rotated90);

        Integer[][] rotated180 = new Integer[getSizeMatr()][getSizeMatr()];
        for (int i = 0; i < getSizeMatr(); i++) {
            for (int j = 0; j < getSizeMatr(); j++) {
                rotated180[getSizeMatr() - i - 1][getSizeMatr() - j - 1] = matr[i][j];
            }
        }
        System.out.println("Матрица после поворота на 180 градусов:");
        printMatr(rotated180);

        Integer[][] rotated270 = new Integer[getSizeMatr()][getSizeMatr()];
        for (int i = 0; i < getSizeMatr(); i++) {
            for (int j = 0; j < getSizeMatr(); j++) {
                rotated270[getSizeMatr() - j - 1][i] = matr[i][j];
            }
        }
        System.out.println("Матрица после поворота на 270 градусов:");
        printMatr(rotated270);
    }

    public void opredMatr() {
        generateMatr(3);

        System.out.println("Матрица:");
        printMatr(getMatr());

        matr = getMatr();

        int detir = matr[0][0] * (matr[1][1] * matr[2][2] - matr[1][2] * matr[2][1])
                - matr[0][1] * (matr[1][0] * matr[2][2] - matr[1][2] * matr[2][0])
                + matr[0][2] * (matr[1][0] * matr[2][1] - matr[1][1] * matr[2][0]);

        System.out.println("Определитель матрицы равен: " + detir);
    }

    public void avgRow() {
        Double[][] matr = new Double[getSizeMatr()][getSizeMatr()];
        Integer[][] intMatr = getMatr();

        for (int i = 0; i < intMatr.length; i++) {
            for (int j = 0; j < intMatr[i].length; j++) {
                matr[i][j] = (double) intMatr[i][j];
            }
        }

        int size = matr.length;

        for (int i = 0; i < size; i++) {
            double rowSum = 0;

            for (int j = 0; j < size; j++) {
                rowSum += matr[i][j];
            }
            printMatr();
            double rowMean = rowSum / size;

            System.out.printf("Среднее арифметическое строки %d: %.3f\n", i + 1, rowMean);

            for (int j = 0; j < size; j++) {
                matr[i][j] = matr[i][j] - rowMean;
            }
        }

        System.out.println("Матрица после вычитания средних арифметических строк:");
        printMatr(matr);
    }

    public void dltMaxEl(){
        generateMatr();
        matr = getMatr();

        printMatr();

        int maxEl= matr[0][0];

        for (int i = 0; i < getSizeMatr(); i++) {
            for (int j = 0; j < getSizeMatr(); j++) {
                if(matr[i][j] > maxEl){
                    maxEl = matr[i][j];
                }
            }
        }

        printMatr();

        System.out.println("Макимальный элемент: " + maxEl);

        boolean[] rowsToRemove = new boolean[getSizeMatr()];
        boolean[] colsToRemove = new boolean[getSizeMatr()];

        for (int i = 0; i < getSizeMatr(); i++) {
            for (int j = 0; j < getSizeMatr(); j++) {
                if (matr[i][j] == maxEl) {
                    rowsToRemove[i] = true;
                    colsToRemove[j] = true;
                }
            }
        }

        int newSize = 0;
        for (boolean row : rowsToRemove) {
            if (!row) {
                newSize++;
            }
        }

        Integer[][] newMatr = new Integer[newSize][newSize];
        int newRow = 0;
        for (int i = 0; i < getSizeMatr(); i++) {
            if (rowsToRemove[i]) continue;

            int newCol = 0;
            for (int j = 0; j < getSizeMatr(); j++) {
                if (colsToRemove[j]) continue;
                newMatr[newRow][newCol] = matr[i][j];
                newCol++;
            }
            newRow++;
        }

        setMatr(newMatr);
        setSizeMatr(newSize);

        System.out.println("Матрица после удаления строк и столбцов, содержащих максимальный элемент:");
        printMatr();
    }

    public void moveMinEl(){
        setSizeMatr(4);
        matr = new Integer[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matr[i][j] = (int) (Math.random() * 100);
            }
        }

        printMatr();


        int minI = 0, minJ = 0;
        int minValue = matr[0][0];

        for (int i = 0; i < sizeMatr; i++) {
            for (int j = 0; j < sizeMatr; j++) {
                if (matr[i][j] < minValue) {
                    minValue = matr[i][j];
                    minI = i;
                    minJ = j;
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для перемещения минимального элемента (0-" + (sizeMatr - 1) + "): ");
        int targetI = scanner.nextInt();
        System.out.println("Введите столбец для перемещения минимального элемента (0-" + (sizeMatr - 1) + "): ");
        int targetJ = scanner.nextInt();

        Integer[] tempRow = matr[minI];
        matr[minI] = matr[targetI];
        matr[targetI] = tempRow;

        for (int i = 0; i < sizeMatr; i++) {
            int temp = matr[i][minJ];
            matr[i][minJ] = matr[i][targetJ];
            matr[i][targetJ] = temp;
        }

        System.out.println("Матрица после перемещения минимального элемента:");
        printMatr();
    }

    public void moveZeroToEnd(){
        int size = 4;
        setSizeMatr(size);
        matr = new Integer[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matr[i][j] = (int) (Math.random() * 10);
            }
        }

        printMatr();

        for (int i = 0; i < sizeMatr; i++) {
            int[] newRow = new int[sizeMatr];
            int index = 0;

            for (int j = 0; j < sizeMatr; j++) {
                if (matr[i][j] != 0) {
                    newRow[index++] = matr[i][j];
                }
            }
            while (index < sizeMatr) {
                newRow[index++] = 0;
            }

            for (int j = 0; j < sizeMatr; j++) {
                matr[i][j] = newRow[j];
            }
        }

        printMatr();
    }

    public void countSaddlePos(){
        int size = 4;
        setSizeMatr(size);
        matr = new Integer[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matr[i][j] = (int) (Math.random() * 10);
            }
        }

        printMatr();

        int count = 0;

        for (int i = 0; i < size; i++) {
            int minInRow = matr[i][0];
            int colIndex = 0;

            for (int j = 1; j < size; j++) {
                if (matr[i][j] < minInRow) {
                    minInRow = matr[i][j];
                    colIndex = j;
                }
            }

            boolean isSaddlePoint = true;
            for (int k = 0; k < size; k++) {
                if (matr[k][colIndex] > minInRow) {
                    isSaddlePoint = false;
                    break;
                }
            }


            if (isSaddlePoint) {
                count++;
                System.out.println("Седловая точка найдена: (" + i + ", " + colIndex + ") = " + minInRow);
            }
        }

        System.out.println("Количество седловых точек: " + count);
    }

    public void matrSum() {
        int size = 4;
        setSizeMatr(size);
        matr = new Integer[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matr[i][j] = (int) ((Math.random() + 1) * 10);
            }
        }

        printMatr();

        for (int i = 0; i < matr.length - 1; i++) {
            for (int j = i + 1; j < matr.length; j++) {
                int sumI = 0;
                for (int num : matr[i]) {
                    sumI += num;
                }

                int sumJ = 0;
                for (int num : matr[j]) {
                    sumJ += num;
                }

                if (sumI > sumJ) {
                    Integer[] temp = matr[i];
                    matr[i] = matr[j];
                    matr[j] = temp;
                }
            }
        }
        System.out.println("Отсортрованная маттрица, по возростанию суммы строк");
        printMatr();
    }

    public void findLocalMin() {
        int size = 4;
        Integer[][] matr = new Integer[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matr[i][j] = (int) ((Math.random() + 1) * 10);
            }
        }

        System.out.println("Исходная матрица:");
        printMatr();

        int localMinimaCount = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int current = matr[i][j];
                boolean isLocalMinimum = true;

                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        if (di == 0 && dj == 0) continue;
                        int ni = i + di, nj = j + dj;
                        if (ni >= 0 && ni < size && nj >= 0 && nj < size && matr[ni][nj] <= current) {
                            isLocalMinimum = false;
                            break;
                        }
                    }
                    if (!isLocalMinimum) break;
                }

                if (isLocalMinimum) localMinimaCount++;
            }
        }

        System.out.println("Число локальных минимумов: " + localMinimaCount);
    }

    public void sortRowByMin(){
        int size = 4;
        Integer[][] matr = new Integer[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matr[i][j] = (int) ((Math.random() + 1) * 10);
            }
        }

        System.out.println("Исходная матрица:");
        printMatr(matr);

        int[] columnSums = new int[size];
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                columnSums[j] += Math.abs(matr[i][j]);
            }
        }

        Integer[] indices = new Integer[size];
        for (int i = 0; i < size; i++) indices[i] = i;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (columnSums[indices[j]] < columnSums[indices[j + 1]]) {
                    int temp = indices[j];
                    indices[j] = indices[j + 1];
                    indices[j + 1] = temp;
                }
            }
        }

        Integer[][] rearrangedMatr = new Integer[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rearrangedMatr[i][j] = matr[i][indices[j]];
            }
        }

        System.out.println("Матрица после перестановки столбцов:");
        printMatr(rearrangedMatr);
    }




}
