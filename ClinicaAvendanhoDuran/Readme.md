# RAMA Marcos


###  Ultimos cambios


    1- He hecho un método de prueba LogIn implementando el patron MVC  
    
Tras la prueba con el Log in, tengo que modificar el método del Model para que pueda haccer una descarga de los usuarios en un arrayList
y de esta manera en el controller, no tener que hacer otra llamada al get conexion.
Finalmente pode hacer la conexión con el usuario indicado a la base de datos

### Diagrama de clases:


```mermaid
classDiagram
    class Persona {
        <<abstract>>
        -nombre: String
        -edad: int
        +getNombre(): String
        +setNombre(nombre: String): void
        +getEdad(): int
        +setEdad(edad: int): void
    }
    class Trabajador {
        -trabajo: String
        +getTrabajo(): String
        +setTrabajo(trabajo: String): void
    }
    class Controller {
        +controlar(model: ModelSConexion, view: View): void
    }
    class muException {
        <<Exception>>
    }
    class ModelDentista {
        +metodo1(): void
        +metodo2(): void
    }
    class ModelLogin {
        +metodo1(): void
        +metodo2(): void
    }
    class ModelRecepcionista {
        +metodo1(): void
        +metodo2(): void
    }
    class ModelRegistro {
        +metodo1(): void
        +metodo2(): void
    }
    class View {
        +mostrarVentanas(): void
    }
    class Admin {
        <<interface>>
    }
    class Dentista {
        <<interface>>
    }
    class Login {
        <<interface>>
    }
    class Registro {
        <<interface>>
    }
    class SConexion {
        +getInstance(): SConexion
        +conectar(): void
        +desconectar(): void
    }

    Persona <|-- Trabajador
    Trabajador o-- SConexion
    Controller --> SConexion
    Controller --> View
    ModelDentista --> SConexion
    ModelLogin --> SConexion
    ModelRecepcionista --> SConexion
    ModelRegistro --> SConexion
    View --> Admin
    View --> Dentista
    View --> Login
    View --> Registro





```

### Diagrama de Secuencia del proyecto


````mermaid
sequenceDiagram
    participant View
    participant Controller
    participant SConexion
    participant Trabajador
    participant Persona

    View->>Controller: controlar(model, view)
    Controller->>SConexion: conectar()
    SConexion-->>Controller: instancia
    Controller->>View: mostrarVentanas()
    View-->>Admin: mostrarVentanas()
    View-->>Dentista: mostrarVentanas()
    View-->>Login: mostrarVentanas()
    View-->>Registro: mostrarVentanas()
    Controller-->>SConexion: desconectar()
    SConexion-->>Controller: instancia





````

