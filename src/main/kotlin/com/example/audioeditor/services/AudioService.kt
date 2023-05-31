package com.example.audioeditor.services

import com.example.audioeditor.models.CutRequestModel
import java.io.File

interface AudioService {
    fun cutFile(dto: CutRequestModel): File
}