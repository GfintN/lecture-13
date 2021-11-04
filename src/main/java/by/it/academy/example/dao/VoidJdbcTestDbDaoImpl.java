package by.it.academy.example.dao;

import by.it.academy.example.entity.CommandsSQL;

import java.sql.SQLException;
import java.util.List;

public class VoidJdbcTestDbDaoImpl implements JdbcTestDbDAO {
    @Override
    public CommandsSQL save(CommandsSQL id) throws SQLException {
        return null;
    }

    @Override
    public CommandsSQL get(CommandsSQL id) throws SQLException {
        return null;
    }

    @Override
    public int update(CommandsSQL commandsSQL) throws SQLException {
        return 0;
    }

    @Override
    public int delete(CommandsSQL id) throws SQLException {
        return 0;
    }

    @Override
    public List<String> getAllTestDbParameter(CommandsSQL id) throws SQLException {
        return null;
    }

    @Override
    public int getOneByTwo(CommandsSQL id) throws SQLException {
        return 0;
    }
}
