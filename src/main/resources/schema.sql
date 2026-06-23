CREATE OR REPLACE FUNCTION actualizar_puntos_pronostico()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE pronostico
    SET puntos_obtenidos = CASE
        WHEN goles_local = NEW.goles_local
             AND goles_visitante = NEW.goles_visitante
        THEN 3
        WHEN (goles_local > goles_visitante AND NEW.goles_local > NEW.goles_visitante)
          OR (goles_local < goles_visitante AND NEW.goles_local < NEW.goles_visitante)
          OR (goles_local = goles_visitante AND NEW.goles_local = NEW.goles_visitante)
        THEN 1
        ELSE 0
    END
    WHERE partido_id = NEW.id;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
//
DROP TRIGGER IF EXISTS trg_actualizar_puntos ON partido;
//
CREATE TRIGGER trg_actualizar_puntos
AFTER INSERT OR UPDATE OF goles_local, goles_visitante ON partido
FOR EACH ROW
EXECUTE FUNCTION actualizar_puntos_pronostico();
//
