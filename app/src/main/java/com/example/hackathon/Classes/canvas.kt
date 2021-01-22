package com.example.hackathon.Classes

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import androidx.core.content.res.ResourcesCompat
import com.example.hackathon.Objects.DataHandler
import com.example.hackathon.R
import java.io.ByteArrayOutputStream
import kotlin.math.abs

class canvas @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    View(context, attrs, defStyleAttr)  {

    private val strokeSize = 12f // has to be float
    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap
    lateinit var bitmapHolder : Bitmap


    private lateinit var frame: Rect


    private val backgroundColor = Color.TRANSPARENT

    private var motionTouchEventX = 0f
    private var motionTouchEventY = 0f

    private var currentX = 0f
    private var currentY = 0f

    private val touchTolerance = ViewConfiguration.get(context).scaledTouchSlop

    private var path = Path()

    private val drawColor = ResourcesCompat.getColor(resources, R.color.black, null)

    private val paint = Paint().apply {
        color = drawColor
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        strokeWidth = strokeSize // default: Hairline-width (really thin)
    }


    // Called when the view should render its content.
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // DRAW STUFF HERE

        canvas?.drawBitmap(extraBitmap, 0f, 0f, null)
        //canvas?.drawRect(frame, paint)
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        if (::extraBitmap.isInitialized) extraBitmap.recycle()

        extraBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)


        if(::bitmapHolder.isInitialized){
            extraBitmap = Bitmap.createBitmap(bitmapHolder)
        }

        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(backgroundColor)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        motionTouchEventX = event.x
        motionTouchEventY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> touchStart()
            MotionEvent.ACTION_MOVE -> touchMove()
            MotionEvent.ACTION_UP -> touchUp()
        }
        return true
    }


    private fun touchStart() {
        path.reset()
        path.moveTo(motionTouchEventX, motionTouchEventY)
        currentX = motionTouchEventX
        currentY = motionTouchEventY
    }

    private fun touchMove() {
        val dx = abs(motionTouchEventX - currentX)
        val dy = abs(motionTouchEventY - currentY)
        if (dx >= touchTolerance || dy >= touchTolerance) {

            /* QuadTo() adds a quadratic bezier from the last point,
            approaching control point (x1,y1), and ending at (x2,y2). */
            path.quadTo(currentX, currentY, (motionTouchEventX + currentX) / 2, (motionTouchEventY + currentY) / 2)
            currentX = motionTouchEventX
            currentY = motionTouchEventY

            // Draw the path in the extra bitmap to cache it.
            extraCanvas.drawPath(path, paint)
        }
        invalidate()
    }

    private fun touchUp() {
        // Reset the path so it doesn't get drawn again.
        path.reset()
    }

    fun setCorrectBitmap(){
        if(DataHandler.currentNote?.hashMap != null){

            val holdBitmap : Bitmap = DataHandler.currentNote!!.hashMap!!

            bitmapHolder =  holdBitmap.copy(Bitmap.Config.ARGB_8888, true)

            this.invalidate()
        }
    }

    private fun canvasClear(){
        extraBitmap.eraseColor(backgroundColor)
    }

    fun canvasReset(){
        canvasClear()
        this.invalidate()
    }

    fun getbitmap(): Bitmap {
        var baos = ByteArrayOutputStream()
        extraBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
        var imageBytes : ByteArray = baos.toByteArray()
        baos.close()
        val decodedBitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)

        println(decodedBitmap)

        return decodedBitmap
    }


}