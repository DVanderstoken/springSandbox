package db.migration;

import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import nc.dva.examples.geo.codes.postaux.CodePostalCommune;

public class V1_0_1__InjectCodesPostaux implements SpringJdbcMigration {

	final String query = "INSERT INTO code_postal(code_postal, code_insee, nom_commune, libelle_acheminement) VALUES ( ?, ?, ?, ?)";

	@Override
	public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
		Gson gson = new Gson();
		InputStreamReader isr = new InputStreamReader(
				getClass().getClassLoader().getResourceAsStream("codes-postaux.json"), "UTF-8");
		JsonReader reader = new JsonReader(isr);
		reader.beginArray();
		while (reader.hasNext()) {
			final CodePostalCommune cpc = gson.fromJson(reader, CodePostalCommune.class);
			cpc.setLibelleAcheminement(StringUtils.replace(cpc.getLibelleAcheminement(), "'", "''"));
			cpc.setNomCommune(StringUtils.replace(cpc.getNomCommune(), "'", "''"));
			jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)
						throws SQLException, DataAccessException {

					ps.setString(1, cpc.getCodePostal());
					ps.setString(2, cpc.getCodeCommune());
					ps.setString(3, cpc.getNomCommune());
					ps.setString(4, cpc.getLibelleAcheminement());

					return ps.execute();

				}
			});
		}
		reader.endArray();
		reader.close();
	}

}