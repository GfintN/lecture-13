package by.it.academy.example.dao;

import by.it.academy.example.entity.CommandsSQL;

import java.sql.SQLException;
import java.util.List;

public interface JdbcTestDbDAO extends DAO<CommandsSQL>{
    List<String> getAllTestDbParameter(CommandsSQL id) throws SQLException;
    int getOneByTwo(CommandsSQL id) throws SQLException;
}
