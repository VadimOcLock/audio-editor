package com.example.audioeditor.services.impl

import com.example.audioeditor.models.CutRequestModel
import com.example.audioeditor.services.AudioService
import com.example.audioeditor.utils.AudioUtils
import org.springframework.stereotype.Service
import java.io.File

@Service
class AudioServiceImpl : AudioService {

    override fun cutFile(dto: CutRequestModel): File {

        return AudioUtils.cutWav(dto.file.bytes.inputStream(), dto.timings.start, dto.timings.end)
    }
}