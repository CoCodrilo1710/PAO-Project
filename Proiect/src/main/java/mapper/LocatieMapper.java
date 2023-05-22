package mapper;

import model.Locatie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class LocatieMapper {
    private static final LocatieMapper INSTANCE = new LocatieMapper();

    private LocatieMapper() {
    }

    public static LocatieMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Locatie> mapToLocatie(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Locatie.builder()
                            .id(resultSet.getInt(1))
                            .nume(resultSet.getString(2))
                            .adresa(resultSet.getString(6))
                            .oras(resultSet.getString(4))
                            .judet(resultSet.getString(3))
                            .tara(resultSet.getString(6))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }
}
