package mapper;

import model.Grupa;
import model.Locatie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class GrupaMapper {

    private static final GrupaMapper INSTANCE = new GrupaMapper();

    private GrupaMapper() {
    }

    public static GrupaMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Grupa> mapToGrupa(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Grupa.builder()
                            .id(resultSet.getInt(1))
                            .numarGrupa(resultSet.getInt(3))
                            .locatie(null)
                            .studenti(null)
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }
}

