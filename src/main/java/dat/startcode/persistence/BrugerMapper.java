package dat.startcode.persistence;

import dat.startcode.entities.Bruger;
import dat.startcode.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrugerMapper implements IBrugerMapper
{
    ConnectionPool connectionPool;

    public BrugerMapper(ConnectionPool connectionPool)
    {
        this.connectionPool = connectionPool;
    }

    @Override
    public Bruger login(String email, String kodeord) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        Bruger bruger = null;

        String sql = "SELECT * FROM bruger WHERE email = ? AND kodeord = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, kodeord);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String rolle = rs.getString("rolle");
                    bruger = new Bruger(email, kodeord, rolle);
                } else
                {
                    throw new DatabaseException("Fejl i brugernavn eller kodeord");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl under indlogning. Der er noget galt med databasen");
        }
        return bruger;
    }

    @Override
    public Bruger opretBruger(String email, String kodeord, String rolle) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        Bruger bruger;
        String sql = "insert into bruger (email, kodeord, rolle) values (?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, kodeord);
                ps.setString(3, rolle);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    bruger = new Bruger(email, kodeord, rolle);
                } else
                {
                    throw new DatabaseException("Brugeren med email = " + email + " kunne ikke oprettes i databasen");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Kunne ikke indsætte bruger i databasen");
        }
        return bruger;
    }


}
