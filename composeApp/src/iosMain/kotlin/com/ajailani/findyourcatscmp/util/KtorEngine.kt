package com.ajailani.findyourcatscmp.util

import io.ktor.client.engine.darwin.Darwin

actual val ktorEngine = Darwin.create()