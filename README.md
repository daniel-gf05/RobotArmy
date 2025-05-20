# RobotArmy

## Descripción
Sistema backend de gestión de robots y misiones. Desarrollado en SpringBoot con lombok usando MongoDB para mayor flexibilidad.

## Sobre los controladores
He creado dos controladores extra (MisionWebController y RobotWebController). Los controladores (@Controller) contienen los endpoints que imprimen la información con un template, mientras que los controladores rest (@RestController) la imprimen como JSON.

## Endpoints @RestController
/robots/{id}/recargar - Establece la energía del robot al máximo. (Por defecto, los robots se generan cargados)
/misiones - (GET) Lista todas las misiones registradas
/robots - (GET) Lista todos los robots registrados
/robots/{id}/subir-nivel
/misiones - (POST) Añade una misión a la BD
/robots - (POST) Añade un robot a la BD
/misiones/{id}/asignar-robot - (PATCH) Asigna un robot a una misión, se le debe pasar la id de la misión, y en el body un String con la id del robot

## Endpoints @Controller (Para templates)
/robots-vista - Lista todos los robots con template
/misiones-vista - Lista todas las misiones con template