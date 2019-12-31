package gtcloud.helper;

import org.geotools.geometry.jts.JTSFactoryFinder;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

public class GeometryHelper {

    public static Point getCentroid(Coordinate[] coordinates) {
        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);
        Polygon polygon = geometryFactory.createPolygon(coordinates);
        Point point = polygon.getCentroid();
        return point;
    }
}
