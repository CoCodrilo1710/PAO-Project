package mapper;

import model.FormaNota;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoteMapper {
    private static final NoteMapper INSTANCE = new NoteMapper();

    private NoteMapper() {
    }

    public static NoteMapper getInstance() {
        return INSTANCE;
    }

    public ArrayList<FormaNota> mapResultToArray(ResultSet resultSet) throws SQLException {
        ArrayList<FormaNota> formaNotaList = new ArrayList<FormaNota>();
        while (resultSet.next()) {
            formaNotaList.add(new FormaNota(resultSet.getInt(3), resultSet.getDate(4).toLocalDate()));
        }
        return formaNotaList;
    }

}
