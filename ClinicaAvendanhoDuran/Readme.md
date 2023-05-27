# RAMA Marcos


###  Ultimos cambios


    1- He hecho un método de prueba LogIn implementando el patron MVC  
    
Tras la prueba con el Log in, tengo que modificar el método del Model para que pueda haccer una descarga de los usuarios en un arrayList
y de esta manera en el controller, no tener que hacer otra llamada al get conexion.
Finalmente pode hacer la conexión con el usuario indicado a la base de datos

### Diagrama de clases:


```mermaid
classDiagram
    class SingletonConexion {
        +getInstance(): SingletonConexion
    }
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
        +controlar(model: ModelConexion, view: View): void
    }
    class muException {
        <<Exception>>
    }
    class ModelConexion {
        +conectar(): void
        +desconectar(): void
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

    SingletonConexion --> ModelConexion
    Persona <|-- Trabajador
    Trabajador o-- SingletonConexion
    Controller --> ModelConexion
    Controller --> View
    ModelDentista --> ModelConexion
    ModelLogin --> ModelConexion
    ModelRecepcionista --> ModelConexion
    ModelRegistro --> ModelConexion
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
    participant ModelConexion
    participant Trabajador
    participant Persona
    participant SingletonConexion

    View->>Controller: controlar(model, view)
    Controller->>ModelConexion: conectar()
    ModelConexion-->>SingletonConexion: getInstance()
    SingletonConexion-->>ModelConexion: instancia
    Controller-->>ModelConexion: instancia
    Controller->>View: mostrarVentanas()
    View-->>Admin: mostrarVentanas()
    View-->>Dentista: mostrarVentanas()
    View-->>Login: mostrarVentanas()
    View-->>Registro: mostrarVentanas()
    Controller-->>ModelConexion: desconectar()
    ModelConexion-->>SingletonConexion: getInstance()
    SingletonConexion-->>ModelConexion: instancia


````

