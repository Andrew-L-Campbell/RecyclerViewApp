package com.example.listmanager

class Motorcycle(val ID: Int , val make: String, val model: String, val engineCC: Int)

fun driver( TQString: String):List<String>{
    var str = TQString
    var delimiter = ","
    val parts = str.split(delimiter)
    for(i in parts){
        i.replace(",","")
    }

    return parts
}
class changeList() {
    val motorcycleList = emptyList<Motorcycle>().toMutableList()
    fun createList() {
        var moto1 = """1,Suzuki,Vstrom,1050"""
        var moto2 = """2,Suzuki,GSXR,988"""
        var moto3 = """3,Kawasaki,H2,998"""
        var moto4 = """4,Suzuki,Hayabusa,1340"""
        var moto5 = """5,Yamaha,R1,998"""
        var moto6 = """6,Yamaha,R6,599"""
        var moto7 = """7,Yamaha,Tenere,1000"""
        var moto8 = """8,Yamaha,MT10,998"""
        var moto9 = """9,Suzuki,Katana,999"""
        var moto10 = """10,Suzuki,Dr650,644"""
        var moto11 = """11,Kawasaki,Versys,1043"""
        var moto12 = """12,Kawasaki,NinjaSX,1043"""

        var inputs = driver(moto1)
        var Vstrom = Motorcycle(
            inputs.elementAt(0).toInt(),
            inputs.elementAt(1),
            inputs.elementAt(2),
            inputs.elementAt(3).toInt()
        )
        motorcycleList.add(Vstrom)
        inputs = driver(moto2)
        var GSXR = Motorcycle(
            inputs.elementAt(0).toInt(),
            inputs.elementAt(1),
            inputs.elementAt(2),
            inputs.elementAt(3).toInt()
        )
        motorcycleList.add(GSXR)
        inputs = driver(moto3)
        var H2 = Motorcycle(
            inputs.elementAt(0).toInt(),
            inputs.elementAt(1),
            inputs.elementAt(2),
            inputs.elementAt(3).toInt()
        )
        motorcycleList.add(H2)
        inputs = driver(moto4)
        var Hayabusa = Motorcycle(
            inputs.elementAt(0).toInt(),
            inputs.elementAt(1),
            inputs.elementAt(2),
            inputs.elementAt(3).toInt()
        )
        motorcycleList.add(Hayabusa)
        inputs = driver(moto5)
        var R1 = Motorcycle(
            inputs.elementAt(0).toInt(),
            inputs.elementAt(1),
            inputs.elementAt(2),
            inputs.elementAt(3).toInt()
        )
        motorcycleList.add(R1)
        inputs = driver(moto6)
        var R6 = Motorcycle(
            inputs.elementAt(0).toInt(),
            inputs.elementAt(1),
            inputs.elementAt(2),
            inputs.elementAt(3).toInt()
        )
        motorcycleList.add(R6)
        inputs = driver(moto7)
        var Tenere = Motorcycle(
            inputs.elementAt(0).toInt(),
            inputs.elementAt(1),
            inputs.elementAt(2),
            inputs.elementAt(3).toInt()
        )
        motorcycleList.add(Tenere)
        inputs = driver(moto8)
        var MT10 = Motorcycle(
            inputs.elementAt(0).toInt(),
            inputs.elementAt(1),
            inputs.elementAt(2),
            inputs.elementAt(3).toInt()
        )
        motorcycleList.add(MT10)
        inputs = driver(moto9)
        var Katana = Motorcycle(
            inputs.elementAt(0).toInt(),
            inputs.elementAt(1),
            inputs.elementAt(2),
            inputs.elementAt(3).toInt()
        )
        motorcycleList.add(Katana)
        inputs = driver(moto10)
        var Dr650 = Motorcycle(
            inputs.elementAt(0).toInt(),
            inputs.elementAt(1),
            inputs.elementAt(2),
            inputs.elementAt(3).toInt()
        )
        motorcycleList.add(Dr650)
        inputs = driver(moto11)
        var Versys = Motorcycle(
            inputs.elementAt(0).toInt(),
            inputs.elementAt(1),
            inputs.elementAt(2),
            inputs.elementAt(3).toInt()
        )
        motorcycleList.add(Versys)
        inputs = driver(moto12)
        var NinjaSX = Motorcycle(
            inputs.elementAt(0).toInt(),
            inputs.elementAt(1),
            inputs.elementAt(2),
            inputs.elementAt(3).toInt()
        )
        motorcycleList.add(NinjaSX)
        for (i in motorcycleList) {
            var myStr = String.format("%d %s %s %d", i.ID, i.make, i.model, i.engineCC)
            println(myStr)
        }
    }

    fun getItemByIndex( ind: Int):Motorcycle {
        return motorcycleList[ind]
    }

    fun getItemById(id: Int): Int {
        for (i in motorcycleList) {
            if (i.ID == id) {
                var myStr = String.format("%d %s %s %d", i.ID, i.make, i.model, i.engineCC)
                return motorcycleList.indexOf(i)
            }
        }
        return 0
    }

    fun addToList(mot: String) {
        println("addToList(${mot})")
        var inputs = driver(mot)
        var duplicate = false
        for (i in motorcycleList) {
            if (i.ID == inputs.elementAt(0).toInt()) {
                println("Cannot add Duplicate Id, Please Change ID and try again")
                duplicate = true
            }
        }
        if (duplicate == false) {
            var newMot = Motorcycle(
                inputs.elementAt(0).toInt(),
                inputs.elementAt(1),
                inputs.elementAt(2),
                inputs.elementAt(3).toInt()
            )
            motorcycleList.add(newMot)
        }
        duplicate = false
    }

    fun deleteFromList(id: Int) {
        var getId = getItemById(id)

        motorcycleList.removeAt(getId)

    }
}