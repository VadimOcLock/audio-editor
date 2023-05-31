package com.example.audioeditor.models

import com.example.audioeditor.utils.AudioUtils
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

data class CutRequestModel(
    @RequestPart("file") val file: MultipartFile,
    @RequestPart("timings") val timings: Timings
)

@JsonSerialize
class Timings(private val dto: TimingsDto) {
    val start = AudioUtils.formatTimings(dto.start)
    val end = AudioUtils.formatTimings(dto.end)
}

@JsonSerialize
data class TimingsDto(
    val start: String,
    val end: String
)
