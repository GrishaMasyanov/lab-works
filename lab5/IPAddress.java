package five;
public class IPAddress {
    public static void main(String[] args) {
        String[] ips = {
                "127.0.0.1",
                "192.168.1.1",
                "255.255.255.255",
                "256.0.0.1",
                "192.168.1",
                "192.168.1.1.1",
                "a.b.c.d",
                null
        };
        for (String ip : ips) {
            try {
                if (ValidIP(ip)) {
                    System.out.println("IP '" + ip + "' is VALID");
                } else {
                    System.out.println("IP '" + ip + "' is INVALID");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error: " + e.getMessage());
            }
        }
    }
    public static boolean ValidIP(String ip) {
        if (ip == null) {
            throw new IllegalArgumentException("IP address cannot be null.");
        }
        String byteRegex = "(25[0-5]|2[0-4][0-9]|[01]?\\d{1,2})";
        String ipRegex = "^(" + byteRegex + "\\.){3}" + byteRegex + "$";
        return ip.matches(ipRegex);
    }
}
