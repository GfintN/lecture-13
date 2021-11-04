package by.it.academy.example.entity;

import org.springframework.stereotype.Component;

@Component
public class CommandsSQL {
    private String update;
    private String insert;
    private String delete;
    private String select;
    private String join;
    private StringBuffer stringBuffer;

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String selectTable, String selectColumnAndValue) {
        stringBuffer = null;
        stringBuffer.append("UPDATE ").append(selectTable).append(" SET ").append(selectColumnAndValue)
                .append(";");
        update = String.valueOf(stringBuffer);
    }

    public String getInsert() {
        return insert;
    }

    public void setInsert(String selectTable, String selectColumnAndValue) {
        stringBuffer = null;
        stringBuffer.append("INSERT INTO ").append(selectTable).append(" VALUES ").append(selectColumnAndValue)
                .append(";");
        insert = String.valueOf(stringBuffer);
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String selectTable, String selectColumnAndValue) {
        stringBuffer = null;
        stringBuffer.append("DELETE FROM ").append(selectTable).append(" WHERE ").append(selectColumnAndValue)
                .append(";");
        delete = String.valueOf(stringBuffer);
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String selectTable, String selectColumn) {
        stringBuffer = null;
        stringBuffer.append("SELECT ").append(selectColumn).append(" FROM ").append(selectTable).append(";");
        select = String.valueOf(stringBuffer);
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String selectTableOne, String selectTableTwo,
                               String columnTableOne, String columnTableTwo) {
        stringBuffer = null;
        stringBuffer.append("SELECT * FROM ").append(selectTableOne).append(" JOIN ").append(selectTableTwo)
                .append(" ON ").append(columnTableOne).append(" = ").append(columnTableTwo).append(";");
        join = String.valueOf(stringBuffer);
    }
}
