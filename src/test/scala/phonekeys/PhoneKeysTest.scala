package phonekeys

import org.scalatest.FunSuite

class PhoneKeysTest extends FunSuite {

  test("translate 7225247386") {
    assert(PhoneKeys.translate("7225247386").contains("scala is fun"))
  }

}
