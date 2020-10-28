package waveshare.feng.nfctag.activity

import android.graphics.Bitmap
import android.nfc.tech.NfcA

/**
 * This class is an adapter required to expose the useful protected and package methods of
 * [waveshare.feng.nfctag.activity.a] (hence the need for it to be in the same package).
 * It also gives the methods better names.
 */
class WaveshareSenderAdapter {

    private var delegate = a()

    fun send(tag: NfcA?, size: Int, bitmap: Bitmap?): Int {
        return delegate.a(tag, size, bitmap)
    }

    fun progress(): Int {
        return delegate.b()
    }

}