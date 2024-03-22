import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

class Solution {

    private static final int SIZE = 51;
    public static final String EMPTY = "EMPTY";

    private final Position[][] parent = new Position[SIZE][SIZE];
    private final String[][] table = new String[SIZE][SIZE];
    private final List<String> prints = new ArrayList<>();
    private final Map<String, Consumer<String[]>> functions = Map.of(
            "UPDATE", this::update,
            "MERGE", this::merge,
            "UNMERGE", this::unmerge,
            "PRINT", this::print
    );

    public String[] solution(String[] commands) {
        for (int i = 1; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                parent[i][j] = new Position(i, j);
                table[i][j] = EMPTY;
            }
        }

        for (String command : commands) {
            String[] splits = command.split(" ");
            functions.get(splits[0]).accept(splits);
        }
        return prints.toArray(new String[0]);
    }

    private void update(String[] splits) {
        if (splits.length != 3) {
            Position position = new Position(splits[1], splits[2]);
            Position root = find(position);
            table[root.row][root.column] = splits[3];
            return;
        }

        for (int i = 1; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                if (splits[1].equals(table[i][j])) {
                    table[i][j] = splits[2];
                }
            }
        }
    }

    private void merge(String[] splits) {
        Position position1 = new Position(splits[1], splits[2]);
        Position position2 = new Position(splits[3], splits[4]);

        Position root1 = find(position1);
        Position root2 = find(position2);

        if (root1.equals(root2)) {
            return;
        }

        String value;
        if (table[root1.row][root1.column].equals(EMPTY)) {
            value = table[root2.row][root2.column];
        } else {
            value = table[root1.row][root1.column];
        }

        table[root1.row][root1.column] = EMPTY;
        table[root2.row][root2.column] = EMPTY;

        union(root1, root2);
        table[root1.row][root1.column] = value;
    }

    private void unmerge(String[] splits) {
        Position position = new Position(splits[1], splits[2]);
        Position root = find(position);

        String value = table[root.row][root.column];
        table[root.row][root.column] = EMPTY;
        table[position.row][position.column] = value;

        List<Position> deletes = new ArrayList<>();
        for (int i = 1; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                Position delete = new Position(i, j);
                if (root.equals(find(delete))) {
                    deletes.add(delete);
                }
            }
        }

        for (Position delete : deletes) {
            parent[delete.row][delete.column] = delete;
        }
    }

    private void print(String[] splits) {
        Position root = find(new Position(splits[1], splits[2]));

        prints.add(table[root.row][root.column]);
    }

    private Position find(Position position) {
        if (parent[position.row][position.column].equals(position)) {
            return position;
        }
        return parent[position.row][position.column] = find(parent[position.row][position.column]);
    }

    private void union(Position position1, Position position2) {
        Position root1 = find(position1);
        Position root2 = find(position2);

        if (root1 != root2) {
            parent[root2.row][root2.column] = root1;
        }
    }


    private static class Position {

        private final int row;
        private final int column;

        private Position(int row, int column) {
            this.row = validate(row);
            this.column = validate(column);
        }

        private Position(String row, String column) {
            this(Integer.parseInt(row), Integer.parseInt(column));
        }

        private int validate(int number) {
            if (0 < number && number <= 50) {
                return number;
            }
            throw new IllegalArgumentException();
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Position position = (Position) o;
            return row == position.row && column == position.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

    }

}
