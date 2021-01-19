package de.tc.cat.the.net;


import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * The class {@code HostInfo } gives information about an IP address.
 * The host name, the IPv4 and the IPv6 address can be retrieved.
 * The information is provided by entering the IPv4, IPv6 or the host name.
 *
 * @author Christian Trostmann
 * @version 1.0
 * @since 15
 */
public class HostInfo {

    private Inet6Address inet6;
    private InetAddress inet4;

    /**
     * Creates the {@code HostInfo } class with a host name or IP address.
     *
     * @param host Specifies the IP address or the host name as a string.
     * @throws IOException is triggered when there are problems with the class.
     */
    public HostInfo(String host) throws IOException {
        for (InetAddress net : inet(host)) {
            if (net.getHostAddress().contains(".")) {
                inet4 = Inet4Address.getByAddress(net.getAddress());
            }
            if (net.getHostAddress().contains(":")) {
                inet6 = Inet6Address.getByAddress(net.getHostName(), net.getAddress(), NetworkInterface.getByInetAddress(net));
            }
        }

    }

    /**
     * Creates the {@code HostInfo } class with a host name or IP address.
     *
     * @param host Specifies the IP address as {@link java.net.InetAddress}.
     * @throws IOException is triggered when there are problems with the class.
     */
    public HostInfo(InetAddress host) throws IOException {
        for (InetAddress net : inet(host.getHostAddress())) {
            if (net.getHostAddress().contains(".")) {
                inet4 = Inet4Address.getByAddress(net.getAddress());
            }
            if (net.getHostAddress().contains(":")) {
                inet6 = Inet6Address.getByAddress(net.getHostName(), net.getAddress(), NetworkInterface.getByInetAddress(net));
            }
        }
    }

    /**
     * Creates the {@code HostInfo } class with a host name or IP address.
     *
     * @param host Specifies the IP address as {@link java.net.Inet6Address}.
     * @throws IOException is triggered when there are problems with the class.
     */
    public HostInfo(Inet6Address host) throws IOException {
        for (InetAddress net : inet(host.getHostName())) {
            if (net.getHostAddress().contains(".")) {
                inet4 = Inet4Address.getByAddress(net.getAddress());
            }
            if (net.getHostAddress().contains(":")) {
                inet6 = Inet6Address.getByAddress(net.getHostName(), net.getAddress(), NetworkInterface.getByInetAddress(net));
            }
        }
    }

    /**
     * Get the IPv4 address.
     *
     * @return Returns the IPv4 address if available.
     */
    public String getIPv4() {
        if (!check(inet4)) {
            return null;
        } else {
            return inet4.getHostAddress();
        }
    }

    /**
     * Get the IPv4 address.
     *
     * @return Returns the IPv6 address if available.
     */
    public String getIpv6() {
        if (!check(inet6)) {
            return null;
        } else {
            return inet6.getHostAddress();
        }
    }

    /**
     * Gets the host name.
     *
     * @return returns the host name as a string.
     */
    public String getHostname() {
        return inet4.getHostName();
    }

    /**
     * Gets the {@link java.net.InetAddress} Object.
     *
     * @return Returns the {@link java.net.InetAddress} object as {@link java.net.InetAddress}.
     */
    public InetAddress getInetAddress() {
        if (check(inet4)) {
            return inet4;
        } else {
            return null;
        }
    }

    /**
     * Gets the {@link java.net.Inet6Address} Object.
     *
     * @return Returns the {@link java.net.Inet6Address} object as {@link java.net.Inet6Address}.
     */
    public Inet6Address getInet6Address() {
        if (check(inet6)) {
            return inet6;
        } else {
            return null;
        }
    }


    private boolean check(InetAddress inet) {
        return inet != null;
    }

    private boolean check(Inet6Address inet) {
        return inet != null;
    }

    private InetAddress[] inet(String ip) throws IOException {
        InetAddress net = InetAddress.getByName(ip);
        if (ip.equals(net.getHostAddress())) {
            return InetAddress.getAllByName(net.getHostName());
        }
        return InetAddress.getAllByName(ip);
    }
}
