package repository;

import java.util.List;

public interface MateriiRepository {
    List<Integer> getIdMateriiByIdStudent(int idStudent, int idMaterie);

    List<String> getAllMaterii();
    public int updateObject(int idStudent, int idMaterie, int nrNote);
}
