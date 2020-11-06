-- --------------------------------------------------------
DROP TABLE IF EXISTS `Participacion`;
DROP TABLE IF EXISTS `Evento`;
DROP TABLE IF EXISTS `Equipo`;
DROP TABLE IF EXISTS `Deporte`;
DROP TABLE IF EXISTS `Deportista`;
DROP TABLE IF EXISTS `Olimpiada`;

--
-- Estructura de tabla para la tabla `Deporte`
--

CREATE TABLE `Deporte` (
  `id_deporte` INTEGER PRIMARY KEY AUTOINCREMENT,
  `nombre` varchar(100) NOT NULL
);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `Deportista`
--

CREATE TABLE `Deportista` (
  `id_deportista` INTEGER PRIMARY KEY,
  `nombre` varchar(150) NOT NULL,
  `sexo` varchar CHECK(sexo IN ('M','F')) NOT NULL,
  `peso` int(11) DEFAULT NULL,
  `altura` int(11) DEFAULT NULL
);


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Equipo`
--

CREATE TABLE `Equipo` (
  `id_equipo` INTEGER PRIMARY KEY AUTOINCREMENT,
  `nombre` varchar(50) NOT NULL,
  `iniciales` varchar(3) NOT NULL
);


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Evento`
--

CREATE TABLE `Evento` (
  `id_evento` INTEGER PRIMARY KEY AUTOINCREMENT,
  `nombre` varchar(150) NOT NULL,
  `id_olimpiada` int(11) NOT NULL,
  `id_deporte` int(11) NOT NULL,
  FOREIGN KEY(`id_olimpiada`) REFERENCES `Olimpiada`(`id_olimpiada`)
  FOREIGN KEY(`id_deporte`) REFERENCES `Deporte`(`id_deporte`)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Olimpiada`
--

CREATE TABLE `Olimpiada` (
  `id_olimpiada` INTEGER PRIMARY KEY AUTOINCREMENT,
  `nombre` varchar(11) NOT NULL,
  `anio` smallint(6) NOT NULL,
  `temporada` VARCHAR CHECK( temporada IN ('Summer','Winter')) NOT NULL,
  `ciudad` varchar(50) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Participacion`
--

CREATE TABLE `Participacion` (
  `id_deportista` INTEGER ,
  `id_evento` INTEGER ,
  `id_equipo` INTEGER(11) NOT NULL,
  `edad` tinyint(4) DEFAULT NULL,
  `medalla` varchar(6) DEFAULT NULL,
  PRIMARY KEY(`id_deportista`, `id_evento`)
  FOREIGN KEY(`id_evento`) REFERENCES `Evento`(`id_evento`)
  FOREIGN KEY(`id_deportista`) REFERENCES `Deportista`(`id_deportista`)
  FOREIGN KEY(`id_equipo`) REFERENCES `Equipo`(`id_equipo`)

);


