//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package waveshare.feng.nfctag.activity

import android.graphics.Bitmap
import android.graphics.Matrix
import android.nfc.tech.NfcA
import android.os.SystemClock
import android.util.Log

class a {
    var a = ByteArray('\ue2e0')
    var b = ByteArray('\ue2e0')
    var c = 0
    var d = intArrayOf(0, 250, 296, 400, 800, 880, 264, 296)
    var e = intArrayOf(0, 122, 128, 300, 480, 528, 176, 128)
    var f = byteArrayOf(0, 19, 19, 103, 123, 123, 124, 77)
    var g = intArrayOf(0, 250, 296, 150, 400, 484, 48, 64)
    var h = byteArrayOf(0, 4, 7, 10, 14, 17, 16, 8)
    var i = intArrayOf(0, 0, 0, 0, 0, 0, 0, 1)

    internal constructor() {
        c = 0
    }

    fun b(): Int {
        return c
    }

    internal constructor(var1: NfcA, var2: Int, var3: Bitmap?) {
        try {
            var var4 = false
            var1.connect()
            var1.setTimeout(1000)
            c = 0
            val var7: ByteArray = "WSDZ10m".toByteArray()
            val var5: ByteArray = var1.transceive(byteArrayOf(48, 0))
            val var6: ByteArray = Arrays.copyOf(var5, 7)
            if (!Arrays.equals(var6, var7)) {
                return 0
            }
            this.a(var1)
            var4 = this.b(var1, var2, var3)
            if (var4) {
                return 1
            }
        } catch (var8: IOException) {
            var8.printStackTrace()
            c = -1
        }
        c = -1
        return 0
    }

    private constructor(var1: NfcA) {
        val var2 = ByteArray(48)
        var var3: ByteArray
        try {
            var3 = var1.transceive(byteArrayOf(48, 4))
            java.lang.System.arraycopy(var3, 0, var2, 0, 16)
            val var4: ByteArray = var1.transceive(byteArrayOf(48, 8))
            java.lang.System.arraycopy(var4, 0, var2, 16, 16)
            val var5: ByteArray = var1.transceive(byteArrayOf(48, 12))
            java.lang.System.arraycopy(var5, 0, var2, 32, 16)
        } catch (var7: IOException) {
            var7.printStackTrace()
        }
        var3 = byteArrayOf(3, 39, -44, 15, 21, 97, 110, 100, 114, 111, 105, 100, 46, 99, 111, 109, 58, 112, 107, 103, 119, 97, 118, 101, 115, 104, 97, 114, 101, 46, 102, 101, 110, 103, 46, 110, 102, 99, 116, 97, 103, -2, 0, 0, 0, 0, 0, 0)
        if (!Arrays.equals(var3, var2)) {
            for (var8 in 0..10) {
                try {
                    var1.transceive(byteArrayOf(-94, (var8 + 4).toByte(), var3[var8 * 4], var3[var8 * 4 + 1], var3[var8 * 4 + 2], var3[var8 * 4 + 3]))
                } catch (var6: IOException) {
                    var6.printStackTrace()
                }
            }
        }
    }

    fun b(var1: NfcA, var2: Int, var3: Bitmap?): Boolean {
        try {
            var var4: ByteArray = var1.transceive(byteArrayOf(-51, 13))
            if (var4[0] == 0 && var4[1] == 0) {
                var4 = var1.transceive(byteArrayOf(-51, 0, h[var2]))
                if (var4[0] == 0 && var4[1] == 0) {
                    SystemClock.sleep(50L)
                    var4 = var1.transceive(byteArrayOf(-51, 1))
                    if (var4[0] == 0 && var4[1] == 0) {
                        SystemClock.sleep(20L)
                        var4 = var1.transceive(byteArrayOf(-51, 2))
                        if (var4[0] == 0 && var4[1] == 0) {
                            SystemClock.sleep(20L)
                            var4 = var1.transceive(byteArrayOf(-51, 3))
                            if (var4[0] == 0 && var4[1] == 0) {
                                SystemClock.sleep(20L)
                                var4 = var1.transceive(byteArrayOf(-51, 5))
                                if (var4[0] == 0 && var4[1] == 0) {
                                    SystemClock.sleep(20L)
                                    var4 = var1.transceive(byteArrayOf(-51, 6))
                                    if (var4[0] == 0 && var4[1] == 0) {
                                        SystemClock.sleep(100L)
                                        val var5: Bitmap = this.a(var3)
                                        val var6 = IntArray(var3.getWidth() * var3.getHeight())
                                        val var7 = IntArray(var5.getWidth() * var5.getHeight())
                                        if (var2 != 1 && var2 != 2 && var2 != 6 && var2 != 7) {
                                            var3.getPixels(var6, 0, var3.getWidth(), 0, 0, var3.getWidth(), var3.getHeight())
                                            var3.getPixels(var7, 0, var3.getWidth(), 0, 0, var3.getWidth(), var3.getHeight())
                                        } else {
                                            if (var3 == null) {
                                                return false
                                            }
                                            val var8: Int = var3.getWidth()
                                            val var9: Int = var3.getHeight()
                                            val var10 = Matrix()
                                            var10.setRotate(270.0f)
                                            val var11: Bitmap = Bitmap.createBitmap(var3, 0, 0, var8, var9, var10, false)
                                            val var12: Bitmap = Bitmap.createBitmap(var5, 0, 0, var8, var9, var10, false)
                                            var11.getPixels(var6, 0, var11.getWidth(), 0, 0, var11.getWidth(), var11.getHeight())
                                            var12.getPixels(var7, 0, var11.getWidth(), 0, 0, var11.getWidth(), var11.getHeight())
                                        }
                                        Log.e("EPD_high = ", " " + e[var2])
                                        Log.e("EPD_width = ", " " + d[var2])
                                        var var14: Byte
                                        var var16: Int
                                        var var17: Int
                                        var var18: Int
                                        if (i[var2] == 0) {
                                            if (var2 == 1) {
                                                var16 = 0
                                                while (var16 < 250) {
                                                    var17 = 0
                                                    while (var17 < 16) {
                                                        var14 = 0
                                                        var18 = 0
                                                        while (var18 < 8) {
                                                            var14 = (var14 shl 1) as Byte
                                                            if (var6[var18 + var17 * 8 + var16 * 128] and 255 > 128) {
                                                                var14 = (var14 or 1) as Byte
                                                            }
                                                            ++var18
                                                        }
                                                        a[var16 * 16 + var17] = var14
                                                        b[var16 * 16 + var17] = 0
                                                        ++var17
                                                    }
                                                    ++var16
                                                }
                                            } else {
                                                var16 = 0
                                                while (var16 < e[var2]) {
                                                    var17 = 0
                                                    while (var17 < d[var2] / 8) {
                                                        var14 = 0
                                                        var18 = 0
                                                        while (var18 < 8) {
                                                            var14 = (var14 shl 1) as Byte
                                                            if (var6[var18 + var17 * 8 + var16 * d[var2]] and 255 > 128) {
                                                                var14 = (var14 or 1) as Byte
                                                            }
                                                            ++var18
                                                        }
                                                        a[var16 * (d[var2] / 8) + var17] = var14
                                                        b[var16 * (d[var2] / 8) + var17] = 0
                                                        ++var17
                                                    }
                                                    ++var16
                                                }
                                            }
                                        } else if (i[var2] == 1) {
                                            var16 = 0
                                            while (var16 < e[var2]) {
                                                var17 = 0
                                                while (var17 < d[var2] / 8) {
                                                    var14 = 0
                                                    var var15: Byte = 0
                                                    var18 = 0
                                                    while (var18 < 8) {
                                                        var14 = (var14 shl 1) as Byte
                                                        var15 = (var15 shl 1) as Byte
                                                        if (var6[var18 + var17 * 8 + var16 * d[var2]] == -1) {
                                                            var14 = (var14 or 1) as Byte
                                                        }
                                                        if (var7[var18 + var17 * 8 + var16 * d[var2]] and 255 > 128) {
                                                            var15 = (var15 or 1) as Byte
                                                        }
                                                        ++var18
                                                    }
                                                    a[var16 * (d[var2] / 8) + var17] = var14
                                                    b[var16 * (d[var2] / 8) + var17] = var15
                                                    ++var17
                                                }
                                                ++var16
                                            }
                                        }
                                        var4 = var1.transceive(byteArrayOf(-51, 7, 0))
                                        if (var4[0] == 0 && var4[1] == 0) {
                                            Log.e("Packet_number = ", " " + g[var2])
                                            Log.e("Packet_size = ", " " + f[var2])
                                            var var20: ByteArray
                                            var16 = 0
                                            while (var16 < g[var2]) {
                                                var20 = ByteArray(f[var2].toInt())
                                                java.lang.System.arraycopy(byteArrayOf(-51, 8, (f[var2] - 3).toByte()), 0, var20, 0, 3)
                                                if (var2 == 6) {
                                                    var18 = 0
                                                    while (var18 < 121) {
                                                        var20[var18 + 3] = -1
                                                        ++var18
                                                    }
                                                } else {
                                                    java.lang.System.arraycopy(a, var16 * (f[var2] - 3), var20, 3, f[var2] - 3)
                                                }
                                                var4 = var1.transceive(var20)
                                                if (var4[0] != 0 || var4[1] != 0) {
                                                    return false
                                                }
                                                if (var2 != 6 && var2 != 7) {
                                                    c = var16 * 100 / g[var2]
                                                } else {
                                                    c = var16 * 50 / g[var2]
                                                }
                                                SystemClock.sleep(2L)
                                                ++var16
                                            }
                                            if (var2 == 5) {
                                                val var19 = ByteArray(113)
                                                java.lang.System.arraycopy(byteArrayOf(-51, 8, 120), 0, var19, 0, 3)
                                                var17 = 0
                                                while (var17 < 110) {
                                                    var19[var17 + 3] = -1
                                                    ++var17
                                                }
                                                var1.transceive(var19)
                                            }
                                            var4 = var1.transceive(byteArrayOf(-51, 24))
                                            if (var4[0] == 0 && var4[1] == 0) {
                                                if (var2 != 6) {
                                                    if (var2 == 7) {
                                                        var16 = 0
                                                        while (var16 < g[var2]) {
                                                            var20 = ByteArray(f[var2].toInt())
                                                            java.lang.System.arraycopy(byteArrayOf(-51, 8, (f[var2] - 3).toByte()), 0, var20, 0, 3)
                                                            java.lang.System.arraycopy(b, var16 * (f[var2] - 3), var20, 3, f[var2] - 3)
                                                            var4 = var1.transceive(var20)
                                                            if (var4[0] != 0 || var4[1] != 0) {
                                                                return false
                                                            }
                                                            c = var16 * 50 / g[var2] + 50
                                                            SystemClock.sleep(1L)
                                                            ++var16
                                                        }
                                                    }
                                                } else {
                                                    SystemClock.sleep(100L)
                                                    var16 = 0
                                                    while (true) {
                                                        if (var16 >= 48) {
                                                            SystemClock.sleep(100L)
                                                            break
                                                        }
                                                        var20 = ByteArray(124)
                                                        java.lang.System.arraycopy(byteArrayOf(-51, 25, 121), 0, var20, 0, 3)
                                                        java.lang.System.arraycopy(a, var16 * 121, var20, 3, 121)
                                                        c = var16 * 50 / 48 + 51
                                                        var4 = var1.transceive(var20)
                                                        if (var4[0] != 0 || var4[1] != 0) {
                                                            return false
                                                        }
                                                        SystemClock.sleep(2L)
                                                        ++var16
                                                    }
                                                }
                                                SystemClock.sleep(200L)
                                                var4 = var1.transceive(byteArrayOf(-51, 9))
                                                if (var4[0] == 0 && var4[1] == 0) {
                                                    SystemClock.sleep(200L)
                                                    var16 = 0
                                                    while (true) {
                                                        ++var16
                                                        var4 = var1.transceive(byteArrayOf(-51, 10))
                                                        if (var4[0] == -1 && var4[1] == 0) {
                                                            var4 = var1.transceive(byteArrayOf(-51, 4))
                                                            if (var4[0] == 0 && var4[1] == 0) {
                                                                c = 100
                                                                return true
                                                            }
                                                            return false
                                                        }
                                                        if (var16 > 100) {
                                                        }
                                                        SystemClock.sleep(25L)
                                                    }
                                                } else {
                                                    return false
                                                }
                                            } else {
                                                return false
                                            }
                                        } else {
                                            return false
                                        }
                                    } else {
                                        return false
                                    }
                                } else {
                                    return false
                                }
                            } else {
                                return false
                            }
                        } else {
                            return false
                        }
                    } else {
                        return false
                    }
                } else {
                    return false
                }
            } else {
                return false
            }
        } catch (var13: IOException) {
            var13.printStackTrace()
            return false
        }
    }

    internal constructor(var1: Bitmap) {
        var var1: Bitmap = var1
        java.util.ArrayList<Any?>()
        var1 = Bitmap.createScaledBitmap(var1, var1.getWidth(), var1.getHeight(), false)
        val var4 = b(var1)
        return var4.a()
    }
}