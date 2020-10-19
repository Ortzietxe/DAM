class Persona:
    def __init__(self,nombre ="",edad=0,dni="",sexo=0,peso=0,altura=0):
        self.nombre = nombre
        self.edad = edad
        self.dni = dni
        self.sexo = sexo
        self.peso = peso
        self.altura = altura

    def getNombre(self):
        return self.__nombre

    def setNombre(self, nombre):
        self.__nombre = nombre

    def getEdad(self):
        return self.__edad

    def setEdad(self, edad):
        self.__edad = edad

    def getSexo(self):
        return self.__sexo

    def setSexo(self, sexo):
        self.__sexo = sexo

    def getPeso(self):
        return self.__peso

    def setPeso(self, peso):
        self.__peso = peso

    def getAltura(self):
        return self.__altura

    def setAltura(self, altura):
        self.__altura = altura

    def calcularIMC(self):
        resultado = 0
        imc = int(p.getPeso())/int(p.getAltura())**2
        if imc<20:
            resultado = -1
            print(p.getNombre() + " estas en tu peso ideal")
        elif 20>= imc <=25:
            resultado = 0
            print(p.getNombre() + " estas por debajo de tu peso ideal")
        elif imc>25:
            resultado = 1
            print(p.getNombre() + " estas por encima de tu peso ideal")

    def esMayorDeEdad(self):
        mayor = False;
        if int(p.getEdad())>=18:
            mayor = True
            print(p.getNombre() + " eres mayor de edad")
        else:
            mayor = False
            print(p.getNombre() + " eres menor de edad")

    def toString(self):
        genero = ""
        letra = str.upper(p.getSexo())
        if str.upper(p.getSexo()) == "H":
            genero = "chico"
        else:
            genero = "chica"
        print("tu nombre es " + p.getNombre() + ", tienes " + p.getEdad() + " años, eres " + genero + ", pesas " + p.getPeso() + "kg y mides " + p.getAltura() + "m")

    def generarDni(self):
        pedirDatos()

def pedirDatos():
    p.setNombre(input("Introduce tu nombre"))
    p.setEdad(input("Introduce tu edad"))
    p.setSexo(input("Introduce tu sexo(H o M)"))
    p.setPeso(input("Introduce tu peso en kg"))
    p.setAltura(input("Introduce tu altura en m"))

p = Persona()

opcion = int(input("Que desea hacer? \n 1.-Calcular IMC\n 2.-Saber si es mayor de edad\n 3.-ToString\n 4.-Generar Dni"))
if opcion == 1:
    pedirDatos()
    p.calcularIMC()
if opcion == 2:
    pedirDatos()
    p.esMayorDeEdad()
if opcion == 3:
    pedirDatos()
    p.toString()
if opcion == 4:
    pedirDatos()
    p.generarDni()