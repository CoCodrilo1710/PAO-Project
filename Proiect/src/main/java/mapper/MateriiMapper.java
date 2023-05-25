package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriiMapper {
    private static final MateriiMapper INSTANCE = new MateriiMapper();

    private MateriiMapper() {
    }

    public static MateriiMapper getInstance() {
        return INSTANCE;
    }

    public List<Integer> mapResultToArray(ResultSet resultSet) throws SQLException {
        ArrayList<Integer> idsList = new ArrayList<>();

        while (resultSet.next()) {
            idsList.add(resultSet.getInt(1));
        }
        return idsList;
    }

    public List<String> allMaterii(ResultSet resultSet) throws SQLException {
        ArrayList<String> materiiList = new ArrayList<>();

        while (resultSet.next()) {
            materiiList.add(resultSet.getString(2));
        }
        return materiiList;
    }
}
