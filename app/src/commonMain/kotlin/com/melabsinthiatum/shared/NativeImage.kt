package com.melabsinthiatum.shared

expect class Image

expect fun ByteArray.toNativeImage(): Image?
