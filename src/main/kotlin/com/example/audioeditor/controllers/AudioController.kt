package com.example.audioeditor.controllers

import com.example.audioeditor.models.CutRequestModel
import com.example.audioeditor.models.Timings
import com.example.audioeditor.models.TimingsDto
import com.example.audioeditor.services.AudioService
import jakarta.servlet.http.HttpServletResponse
import jakarta.validation.Valid
import org.jetbrains.annotations.NotNull
import org.springframework.core.io.FileSystemResource
import org.springframework.http.HttpHeaders
import org.springframework.util.FileCopyUtils
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.net.URLConnection

@RestController
@RequestMapping("/audio")
class AudioController(
    private val audioService: AudioService
) {

    @CrossOrigin
    @RequestMapping(
        path = ["/test"],
        method = [RequestMethod.POST],
        consumes = ["multipart/form-data"]
    )
    fun cut(
        response: HttpServletResponse,
        @RequestPart("file") @Valid @NotNull file: MultipartFile,
        @RequestPart("timings") @Valid @NotNull timingsDto: TimingsDto
    ) {

        val timings = Timings(timingsDto)
        val requestModel = CutRequestModel(file, timings)
        val cutFile = audioService.cutFile(requestModel)
        val resource = FileSystemResource(cutFile)

        val mimeType = URLConnection.guessContentTypeFromName(cutFile.name) ?: "application/octet-stream"

        response.addHeader(
            HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + resource.filename + "\"")
        response.contentType = mimeType
        response.setContentLength(cutFile.length().toInt())
        val inputStream = BufferedInputStream(FileInputStream(cutFile))
        FileCopyUtils.copy(inputStream, response.outputStream)
        response.outputStream.flush()
    }

    @GetMapping("/test")
    fun test(): String{
        return "It works!"
    }
}