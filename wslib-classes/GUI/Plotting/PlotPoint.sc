// wslib 2007
// Plots a point in a new window

PlotPoint {
	var <>window, <view, <range = 1, <includeNeg = true, <point;
	var <pointSize = 5, <pointColor, <lineSize = 1, <lineColor;
	var <labelFont, <flipped = true;
	
	*new { |point|
		point ? Point(1,1);
		^super.new.init( point );
		}
		
	init { |point|
		window = SCWindow( "Point" ).front;
		pointColor = pointColor ?? { Color.black };
		lineColor = lineColor ?? { Color.black.alpha_(0.5) };
		labelFont = labelFont ?? { Font( "Monaco", 9 ) };
		view = SCUserView( window, window.view.bounds.insetBy(8,8) );
		view.resize_( 5 );
		
		range = 10**(point.x.abs.max( point.y.abs ).log10.ceil);
		includeNeg = point.x.isNegative or: point.y.isNegative;
		
		view.drawFunc = { |vw|
		
			var rectsize, center, strB, negStrB;
			var scaledPoint;
			rectsize = vw.bounds.height.min( vw.bounds.width );
			center = vw.bounds.center;
			if( includeNeg )
				{ Pen.width = lineSize;
				  lineColor.set;
				  Pen.line( vw.bounds.left@center.y,  vw.bounds.right@center.y ).stroke;
				  Pen.line(center.x@vw.bounds.top,  center.x@vw.bounds.bottom ).stroke;
				  
				  ((1,2..10)).do({ |i| 
				  	var vPos, label;
				  	vPos = center.y + ((i/20) * rectsize);
				  	Pen.line( (center.x - 3)@vPos,(center.x + 3)@vPos ).stroke;
					});
					
				 ((1,2..10)).do({ |i| 
				  	var vPos, label;
				  	vPos = center.y - ((i/20) * rectsize);
				  	Pen.line( (center.x - 3)@vPos,(center.x + 3)@vPos ).stroke;
				  	
					});
					
				 ((1,2..10)).do({ |i| 
				  	var hPos, label;
				  	hPos = center.x + ((i/20) * rectsize);
				  	Pen.line( hPos@(center.y - 3),  hPos@(center.y + 3)).stroke;
				  	});
					
				 ((1,2..10)).do({ |i| 
				  	var hPos, label;
				  	hPos = center.x - ((i/20) * rectsize);
				  	Pen.line( hPos@(center.y - 3),  hPos@(center.y + 3)).stroke;
					});
					
				strB = range.asString.bounds( labelFont );
				negStrB = range.neg.asString.bounds( labelFont );
				
				range.neg.asString.drawAtPoint(
					(center.x - (rectsize/2))@(center.y - (negStrB.height + 4) ),
					labelFont, lineColor );
						
				range.asString.drawAtPoint(
					(center.x + (rectsize/2))@(center.y - (strB.height + 4) ),
					labelFont, lineColor	);
						
				range.neg.asString.drawAtPoint(
					(center.x + 4)@((center.y + (rectsize/2)) - negStrB.height  ),
					labelFont, lineColor	);
						
				range.asString.drawAtPoint(
					(center.x + 4)@(center.y - (rectsize/2)),
					labelFont, lineColor
						);
					
				pointColor.set;
				
				scaledPoint = (((point * (1@(-1))) / range)) * (rectsize/2);
				
				//scaledPoint.postln;
				
				Pen.addArc( scaledPoint + center, pointSize / 2, 0, 2pi).stroke;
				Pen.cross( scaledPoint + center, pointSize, '+' );
				Pen.stroke;  	
				}
				
				{ Pen.width = lineSize;
				  lineColor.set;
				  Pen.line( vw.bounds.leftTop,  vw.bounds.leftBottom );
				  Pen.lineTo( vw.bounds.rightBottom ).stroke;
				   ((1,2..10)).do({ |i| 
				  	var vPos, label;
				  	vPos = vw.bounds.bottom - ((i/10) * rectsize);
				  	Pen.line( vw.bounds.left@vPos,(vw.bounds.left + 2)@vPos ).stroke;
				  	});
				
				 ((1,2..10)).do({ |i| 
				  	var hPos, label;
				  	hPos = vw.bounds.left + ((i/10) * rectsize);
				  	Pen.line( hPos@(vw.bounds.bottom),  hPos@(vw.bounds.bottom - 2)).stroke;
					});
				  
				strB = range.asString.bounds( labelFont );
										
				range.asString.drawAtPoint(
					 (vw.bounds.left + 3)@(vw.bounds.bottom - rectsize ), 
					 labelFont, lineColor 
					 );
						
				range.asString.drawAtPoint(
					(vw.bounds.left + rectsize)@(vw.bounds.bottom -3)
					 - (strB.extent), labelFont, lineColor
					);
						
				pointColor.set;
				
				scaledPoint = (((point * (1@(-1))) / range) ) * (rectsize);
				//scaledPoint.postln;
				
				Pen.addArc( scaledPoint + vw.bounds.leftBottom, pointSize / 2, 0, 2pi).stroke;
				Pen.cross( scaledPoint + vw.bounds.leftBottom, pointSize, '+' );
				Pen.stroke;
				};
			
			
			};
		
		
		
		}
	}