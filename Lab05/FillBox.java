public class FillBox {
    char userChar;
    int row;
    int column;

    static char[][] createArray(int row, int column) {
        char[][] arrayChar = new char[row][column];

        for (int i = 0; i < row; i++) {
            arrayChar[i][0] = '#';
            arrayChar[i][column - 1] = '#';
            for (int j = 1; j < column - 1; j++) {
                if (i == 0 || i == row - 1) {
                    arrayChar[i][j] = '#';
                }
                else {
                    arrayChar[i][j] = ' ';
                }
            }
        }

        return arrayChar;
    }

    static void printArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    static void fillBox(char[][] array, int row, int column, char ch) {
        if (array[row][column] == ' ') {
            array[row][column] = ch;
            fillBox(array, row, column + 1, ch);
            fillBox(array, row, column - 1, ch);
            fillBox(array, row + 1, column , ch);
            fillBox(array, row - 1,column, ch);
        }
    }

    public static void main(String[] args) {
        char[][] array = createArray(49,49);
        drawFigure(array, 0, 0, 49);
        printArray(array);
    }

    static void drawFigure(char[][] square, int x, int y, int size) {
        if (size > 7) {
            for (int i = 0; i < size; i++) {
                square[x + size / 2][i+y] = '#';
                square[i+x][y + size / 2] = '#';
            }

            drawFigure(square, x, y, size / 2 + 1);
            drawFigure(square, x + size / 2, y, size / 2 + 1);
            drawFigure(square, x, y+ size / 2, size / 2 + 1);
            drawFigure(square, x+ size / 2, y+ size / 2, size / 2 + 1);
        }

        fillBox(square, x + 1, y + 1, '*');
        if (size < 7) {
            drawFigure(square, x , y , size / 2);
        }
    }
}
