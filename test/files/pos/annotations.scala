class ann(i: Int) extends Annotation

object Test {

  // bug #1028
  val x = 1
  @ann(x) val a = ()
  @ann({val yy = 2; yy}) val b = ()
  val bb: Int @ann({val yy = 2; yy}) = 10

  def c: Int @ann(x) = 1
  def d: String @ann({val z = 0; z - 1}) = "2"

  //bug #1214
  val y = new (Integer @ann(0))(2)

  import scala.reflect.BeanProperty

  // bug #637
  trait S { def getField(): Int }
  class O extends S { @BeanProperty val field = 0 }

  // bug #1070
  trait T { @BeanProperty var field = 1 }
}

